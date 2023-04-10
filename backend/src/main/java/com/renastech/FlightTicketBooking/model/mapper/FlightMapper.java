package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.FlightDto;
import com.renastech.FlightTicketBooking.model.entity.Flight;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateFlightRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightMapper FLIGHT_MAPPER= Mappers.getMapper(FlightMapper.class);

    FlightDto toFlightDto(Flight flight);

    List<FlightDto> toFlightDtoList(List<Flight> flightList);

    Flight createFlight(CreateUpdateFlightRequest request);

    void updateFlight(@MappingTarget Flight flight,CreateUpdateFlightRequest createUpdateFlightRequest);

}
