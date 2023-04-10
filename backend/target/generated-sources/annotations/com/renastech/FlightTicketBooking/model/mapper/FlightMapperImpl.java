package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.AirlineCompanyDto;
import com.renastech.FlightTicketBooking.model.dto.AirlineCompanyDto.AirlineCompanyDtoBuilder;
import com.renastech.FlightTicketBooking.model.dto.AirportDto;
import com.renastech.FlightTicketBooking.model.dto.AirportDto.AirportDtoBuilder;
import com.renastech.FlightTicketBooking.model.dto.CityDto;
import com.renastech.FlightTicketBooking.model.dto.CityDto.CityDtoBuilder;
import com.renastech.FlightTicketBooking.model.dto.FlightDto;
import com.renastech.FlightTicketBooking.model.dto.FlightDto.FlightDtoBuilder;
import com.renastech.FlightTicketBooking.model.dto.TicketPriceDto;
import com.renastech.FlightTicketBooking.model.dto.TicketPriceDto.TicketPriceDtoBuilder;
import com.renastech.FlightTicketBooking.model.entity.AirlineCompany;
import com.renastech.FlightTicketBooking.model.entity.Airport;
import com.renastech.FlightTicketBooking.model.entity.City;
import com.renastech.FlightTicketBooking.model.entity.Flight;
import com.renastech.FlightTicketBooking.model.entity.Flight.FlightBuilder;
import com.renastech.FlightTicketBooking.model.entity.TicketPrice;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateFlightRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-10T21:31:15-0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class FlightMapperImpl implements FlightMapper {

    @Override
    public FlightDto toFlightDto(Flight flight) {
        if ( flight == null ) {
            return null;
        }

        FlightDtoBuilder flightDto = FlightDto.builder();

        if ( flight.getId() != null ) {
            flightDto.id( flight.getId() );
        }
        flightDto.flightCode( flight.getFlightCode() );
        flightDto.departureDate( flight.getDepartureDate() );
        flightDto.arrivalDate( flight.getArrivalDate() );
        flightDto.departureTime( flight.getDepartureTime() );
        flightDto.arrivalTime( flight.getArrivalTime() );
        if ( flight.getPilotId() != null ) {
            flightDto.pilotId( flight.getPilotId() );
        }
        if ( flight.getAirplaneId() != null ) {
            flightDto.airplaneId( flight.getAirplaneId() );
        }
        if ( flight.getTicketPriceId() != null ) {
            flightDto.ticketPriceId( flight.getTicketPriceId() );
        }
        if ( flight.getAvailable() != null ) {
            flightDto.available( flight.getAvailable() );
        }
        if ( flight.getSeatLeft() != null ) {
            flightDto.seatLeft( flight.getSeatLeft() );
        }
        if ( flight.getDepartureAirportId() != null ) {
            flightDto.departureAirportId( flight.getDepartureAirportId() );
        }
        if ( flight.getArrivalAirportId() != null ) {
            flightDto.arrivalAirportId( flight.getArrivalAirportId() );
        }
        flightDto.departureAirport( airportToAirportDto( flight.getDepartureAirport() ) );
        flightDto.ticketPrice( ticketPriceToTicketPriceDto( flight.getTicketPrice() ) );
        flightDto.arrivalAirport( airportToAirportDto( flight.getArrivalAirport() ) );
        flightDto.company( airlineCompanyToAirlineCompanyDto( flight.getCompany() ) );

        return flightDto.build();
    }

    @Override
    public List<FlightDto> toFlightDtoList(List<Flight> flightList) {
        if ( flightList == null ) {
            return null;
        }

        List<FlightDto> list = new ArrayList<FlightDto>( flightList.size() );
        for ( Flight flight : flightList ) {
            list.add( toFlightDto( flight ) );
        }

        return list;
    }

    @Override
    public Flight createFlight(CreateUpdateFlightRequest request) {
        if ( request == null ) {
            return null;
        }

        FlightBuilder<?, ?> flight = Flight.builder();

        flight.flightCode( request.getFlightCode() );
        if ( request.getDepartureDate() != null ) {
            flight.departureDate( LocalDate.parse( request.getDepartureDate() ) );
        }
        if ( request.getArrivalDate() != null ) {
            flight.arrivalDate( LocalDate.parse( request.getArrivalDate() ) );
        }
        flight.departureTime( request.getDepartureTime() );
        flight.arrivalTime( request.getArrivalTime() );
        flight.departureAirportId( request.getDepartureAirportId() );
        flight.arrivalAirportId( request.getArrivalAirportId() );
        flight.pilotId( request.getPilotId() );
        flight.companyId( request.getCompanyId() );
        flight.airplaneId( request.getAirplaneId() );
        flight.ticketPriceId( request.getTicketPriceId() );

        return flight.build();
    }

    @Override
    public void updateFlight(Flight flight, CreateUpdateFlightRequest createUpdateFlightRequest) {
        if ( createUpdateFlightRequest == null ) {
            return;
        }

        flight.setFlightCode( createUpdateFlightRequest.getFlightCode() );
        if ( createUpdateFlightRequest.getDepartureDate() != null ) {
            flight.setDepartureDate( LocalDate.parse( createUpdateFlightRequest.getDepartureDate() ) );
        }
        else {
            flight.setDepartureDate( null );
        }
        if ( createUpdateFlightRequest.getArrivalDate() != null ) {
            flight.setArrivalDate( LocalDate.parse( createUpdateFlightRequest.getArrivalDate() ) );
        }
        else {
            flight.setArrivalDate( null );
        }
        flight.setDepartureTime( createUpdateFlightRequest.getDepartureTime() );
        flight.setArrivalTime( createUpdateFlightRequest.getArrivalTime() );
        flight.setDepartureAirportId( createUpdateFlightRequest.getDepartureAirportId() );
        flight.setArrivalAirportId( createUpdateFlightRequest.getArrivalAirportId() );
        flight.setPilotId( createUpdateFlightRequest.getPilotId() );
        flight.setCompanyId( createUpdateFlightRequest.getCompanyId() );
        flight.setAirplaneId( createUpdateFlightRequest.getAirplaneId() );
        flight.setTicketPriceId( createUpdateFlightRequest.getTicketPriceId() );
    }

    protected CityDto cityToCityDto(City city) {
        if ( city == null ) {
            return null;
        }

        CityDtoBuilder cityDto = CityDto.builder();

        if ( city.getId() != null ) {
            cityDto.id( city.getId() );
        }
        cityDto.cityName( city.getCityName() );
        if ( city.getCountryId() != null ) {
            cityDto.countryId( city.getCountryId() );
        }

        return cityDto.build();
    }

    protected AirportDto airportToAirportDto(Airport airport) {
        if ( airport == null ) {
            return null;
        }

        AirportDtoBuilder airportDto = AirportDto.builder();

        if ( airport.getId() != null ) {
            airportDto.id( airport.getId() );
        }
        airportDto.name( airport.getName() );
        airportDto.details( airport.getDetails() );
        if ( airport.getCityId() != null ) {
            airportDto.cityId( airport.getCityId() );
        }
        airportDto.cityCode( airport.getCityCode() );
        if ( airport.getGateCapacity() != null ) {
            airportDto.gateCapacity( airport.getGateCapacity() );
        }
        airportDto.cities( cityToCityDto( airport.getCities() ) );

        return airportDto.build();
    }

    protected TicketPriceDto ticketPriceToTicketPriceDto(TicketPrice ticketPrice) {
        if ( ticketPrice == null ) {
            return null;
        }

        TicketPriceDtoBuilder ticketPriceDto = TicketPriceDto.builder();

        if ( ticketPrice.getId() != null ) {
            ticketPriceDto.id( ticketPrice.getId() );
        }
        if ( ticketPrice.getAmount() != null ) {
            ticketPriceDto.amount( ticketPrice.getAmount() );
        }

        return ticketPriceDto.build();
    }

    protected AirlineCompanyDto airlineCompanyToAirlineCompanyDto(AirlineCompany airlineCompany) {
        if ( airlineCompany == null ) {
            return null;
        }

        AirlineCompanyDtoBuilder airlineCompanyDto = AirlineCompanyDto.builder();

        if ( airlineCompany.getId() != null ) {
            airlineCompanyDto.id( airlineCompany.getId() );
        }
        airlineCompanyDto.companyName( airlineCompany.getCompanyName() );
        airlineCompanyDto.companyDetail( airlineCompany.getCompanyDetail() );

        return airlineCompanyDto.build();
    }
}
