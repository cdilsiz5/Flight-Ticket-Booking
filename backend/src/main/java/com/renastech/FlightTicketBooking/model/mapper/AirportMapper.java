package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.AirportDto;
import com.renastech.FlightTicketBooking.model.entity.Airport;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateAirportRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirportMapper {
    AirportMapper AIRPORT_MAPPER= Mappers.getMapper(AirportMapper.class);

    AirportDto toAirportDto(Airport airport);

    List<AirportDto> toAirportDtoList(List<Airport> airportList);

    Airport createAirport(CreateUpdateAirportRequest request);

    void updateAirport(@MappingTarget Airport airport,CreateUpdateAirportRequest request);

}
