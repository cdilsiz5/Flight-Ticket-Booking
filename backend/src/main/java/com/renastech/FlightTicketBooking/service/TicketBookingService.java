package com.renastech.FlightTicketBooking.service;

import com.renastech.FlightTicketBooking.exception.BussinesException;
import com.renastech.FlightTicketBooking.exception.NotFoundException;

import com.renastech.FlightTicketBooking.model.dto.TicketBookingDto;
import com.renastech.FlightTicketBooking.model.entity.Airplane;
import com.renastech.FlightTicketBooking.model.entity.Flight;
import com.renastech.FlightTicketBooking.model.entity.TicketBooking;
import com.renastech.FlightTicketBooking.model.entity.Travellers;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateTicketBookingRequest;
import com.renastech.FlightTicketBooking.repository.AirplaneRepository;
import com.renastech.FlightTicketBooking.repository.FlightRepository;
import com.renastech.FlightTicketBooking.repository.TicketBookingRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static com.renastech.FlightTicketBooking.model.mapper.TicketBookingMapper.TICKET_BOOKING_MAPPER;

@Service
@RequiredArgsConstructor
public class TicketBookingService {
    private final TicketBookingRepository repository;
    private final AirplaneRepository airplaneRepository;
    private final FlightRepository flightRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String createTicketBooking(CreateUpdateTicketBookingRequest request){
        validateTicketBooking(request);
        Flight flight=flightRepository.findById(request.getFlightId()).orElseThrow(()-> new NotFoundException("Flight is Not Found"));
        String confirmationNumber=createConfirmationNumber();
        for (Travellers t :request.getList()) {
            repository.save(TicketBooking.builder()
                    .flightId(flight.getId())
                    .lastname(t.getLastname())
                    .userGender(t.getUserGender())
                    .firstname(t.getFirstname())
                    .confirmationNumber(confirmationNumber)
                    .build());
        }
        return confirmationNumber;

    }

    private String createConfirmationNumber() {
        String confirmationNumber =  RandomStringUtils.randomAlphanumeric(6).toUpperCase();
        return confirmationNumber;
    }



    public List<TicketBookingDto> getTicketBookingList(){
        return  TICKET_BOOKING_MAPPER.toTicketBookingDtoList(repository.findAll());
    }

   @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteTicketBooking(String confirmationNumber){
        List<TicketBooking> ticketBookingList= repository.findByConfirmationNumber(confirmationNumber.toUpperCase());
        if(ticketBookingList.isEmpty()){
            throw new BussinesException("Please Check The PNR Number");
        }
        int ticketNumber= ticketBookingList.size();
        Flight flight=flightRepository.findById(ticketBookingList.get(0).getFlightId()).orElseThrow(()->new BussinesException("ticket could not cancelled"));
        if (!flight.getAvailable()){
            throw new BussinesException("This Ticket Cannot Be Cancelled");

        }
        Airplane airplane=airplaneRepository.getById(flight.getAirplaneId());
        flightRepository.setSeatLeft(flight.getId(),(airplane.getAirplaneCapacity())+ticketNumber);
        for (TicketBooking t: ticketBookingList) {
           repository.deleteById(t.getId());
       }

    }

    public void validateTicketBooking(CreateUpdateTicketBookingRequest request){
        Flight flight=flightRepository.findById(request.getFlightId()).orElseThrow(()->new BussinesException(""));
        List<TicketBooking> numOfTicket=repository.findByFlightId(flight.getId());
        int ticketSold= numOfTicket.size();
        Airplane airplane=airplaneRepository.getById(flight.getAirplaneId());
        int leftSeat=airplane.getAirplaneCapacity()-ticketSold;
        if(leftSeat<=0){
            flightRepository.setAvailable(flight.getId(),false);
            throw new BussinesException("There is no empty Left");
        }else if(leftSeat>0&&(leftSeat-request.getList().size()<0)){
            throw new BussinesException("There is no empty Left");
        }
        flightRepository.setSeatLeft(flight.getId(),(leftSeat-request.getList().size()));

    }

    public  List<TicketBookingDto> getTicketBookingByConfirmationNumber(String confirmationNumber) {
        List<TicketBooking> ticketBooking=repository.findByConfirmationNumber(confirmationNumber.toUpperCase());
        if(ticketBooking.isEmpty()){
            throw new BussinesException("Please Check The PNR Number");
        }
        return TICKET_BOOKING_MAPPER.toTicketBookingDtoList(ticketBooking);

    }
}
