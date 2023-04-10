package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.TicketBookingDto;
import com.renastech.FlightTicketBooking.model.dto.TicketBookingDto.TicketBookingDtoBuilder;
import com.renastech.FlightTicketBooking.model.entity.TicketBooking;
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
public class TicketBookingMapperImpl implements TicketBookingMapper {

    @Override
    public TicketBookingDto toTicketBookingDto(TicketBooking ticketBooking) {
        if ( ticketBooking == null ) {
            return null;
        }

        TicketBookingDtoBuilder ticketBookingDto = TicketBookingDto.builder();

        if ( ticketBooking.getId() != null ) {
            ticketBookingDto.id( ticketBooking.getId() );
        }
        if ( ticketBooking.getFlightId() != null ) {
            ticketBookingDto.flightId( ticketBooking.getFlightId() );
        }
        ticketBookingDto.firstname( ticketBooking.getFirstname() );
        ticketBookingDto.lastname( ticketBooking.getLastname() );
        ticketBookingDto.userGender( ticketBooking.getUserGender() );

        return ticketBookingDto.build();
    }

    @Override
    public List<TicketBookingDto> toTicketBookingDtoList(List<TicketBooking> ticketBookingList) {
        if ( ticketBookingList == null ) {
            return null;
        }

        List<TicketBookingDto> list = new ArrayList<TicketBookingDto>( ticketBookingList.size() );
        for ( TicketBooking ticketBooking : ticketBookingList ) {
            list.add( toTicketBookingDto( ticketBooking ) );
        }

        return list;
    }
}
