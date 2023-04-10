package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.CityDto;
import com.renastech.FlightTicketBooking.model.dto.CityDto.CityDtoBuilder;
import com.renastech.FlightTicketBooking.model.entity.City;
import com.renastech.FlightTicketBooking.model.entity.City.CityBuilder;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateCityRequest;
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
public class CityMapperImpl implements CityMapper {

    @Override
    public CityDto toCityDto(City city) {
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

    @Override
    public List<CityDto> toCityDtoList(List<City> cityList) {
        if ( cityList == null ) {
            return null;
        }

        List<CityDto> list = new ArrayList<CityDto>( cityList.size() );
        for ( City city : cityList ) {
            list.add( toCityDto( city ) );
        }

        return list;
    }

    @Override
    public City createCity(CreateUpdateCityRequest request) {
        if ( request == null ) {
            return null;
        }

        CityBuilder<?, ?> city = City.builder();

        city.cityName( request.getCityName() );
        city.countryId( request.getCountryId() );

        return city.build();
    }

    @Override
    public void updateCity(City city, CreateUpdateCityRequest request) {
        if ( request == null ) {
            return;
        }

        city.setCityName( request.getCityName() );
        city.setCountryId( request.getCountryId() );
    }
}
