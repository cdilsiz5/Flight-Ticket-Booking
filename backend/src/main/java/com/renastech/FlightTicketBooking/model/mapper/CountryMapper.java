package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.CountryDto;
import com.renastech.FlightTicketBooking.model.entity.Country;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateCountryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CountryMapper {

    CountryMapper COUNTRY_MAPPER= Mappers.getMapper(CountryMapper.class);

    CountryDto toCountryDto(Country country);

    List<CountryDto> toCountryDtoList(List<Country> countryList);

    Country createCountry(CreateUpdateCountryRequest request);

    void updateCountry(@MappingTarget Country country,CreateUpdateCountryRequest request);

}
