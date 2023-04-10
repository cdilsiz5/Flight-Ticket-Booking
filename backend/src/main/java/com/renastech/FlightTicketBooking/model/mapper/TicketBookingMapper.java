package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.TicketBookingDto;
import com.renastech.FlightTicketBooking.model.entity.TicketBooking;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateTicketBookingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketBookingMapper {

    TicketBookingMapper TICKET_BOOKING_MAPPER= Mappers.getMapper(TicketBookingMapper.class);

    TicketBookingDto toTicketBookingDto(TicketBooking ticketBooking);

    List<TicketBookingDto> toTicketBookingDtoList(List<TicketBooking> ticketBookingList);



}
