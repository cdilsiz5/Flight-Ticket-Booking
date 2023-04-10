package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.AirportDto;
import com.renastech.FlightTicketBooking.model.dto.AirportDto.AirportDtoBuilder;
import com.renastech.FlightTicketBooking.model.dto.CityDto;
import com.renastech.FlightTicketBooking.model.dto.CityDto.CityDtoBuilder;
import com.renastech.FlightTicketBooking.model.entity.Airport;
import com.renastech.FlightTicketBooking.model.entity.Airport.AirportBuilder;
import com.renastech.FlightTicketBooking.model.entity.City;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateAirportRequest;
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
public class AirportMapperImpl implements AirportMapper {

    @Override
    public AirportDto toAirportDto(Airport airport) {
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

    @Override
    public List<AirportDto> toAirportDtoList(List<Airport> airportList) {
        if ( airportList == null ) {
            return null;
        }

        List<AirportDto> list = new ArrayList<AirportDto>( airportList.size() );
        for ( Airport airport : airportList ) {
            list.add( toAirportDto( airport ) );
        }

        return list;
    }

    @Override
    public Airport createAirport(CreateUpdateAirportRequest request) {
        if ( request == null ) {
            return null;
        }

        AirportBuilder<?, ?> airport = Airport.builder();

        airport.name( request.getName() );
        airport.details( request.getDetails() );
        airport.gateCapacity( request.getGateCapacity() );
        airport.cityId( request.getCityId() );
        airport.cityCode( request.getCityCode() );

        return airport.build();
    }

    @Override
    public void updateAirport(Airport airport, CreateUpdateAirportRequest request) {
        if ( request == null ) {
            return;
        }

        airport.setName( request.getName() );
        airport.setDetails( request.getDetails() );
        airport.setGateCapacity( request.getGateCapacity() );
        airport.setCityId( request.getCityId() );
        airport.setCityCode( request.getCityCode() );
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
}
