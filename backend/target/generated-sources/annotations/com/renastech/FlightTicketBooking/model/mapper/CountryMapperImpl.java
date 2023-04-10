package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.CountryDto;
import com.renastech.FlightTicketBooking.model.dto.CountryDto.CountryDtoBuilder;
import com.renastech.FlightTicketBooking.model.entity.Country;
import com.renastech.FlightTicketBooking.model.entity.Country.CountryBuilder;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateCountryRequest;
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
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryDto toCountryDto(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDtoBuilder countryDto = CountryDto.builder();

        if ( country.getId() != null ) {
            countryDto.id( country.getId() );
        }
        countryDto.countryName( country.getCountryName() );

        return countryDto.build();
    }

    @Override
    public List<CountryDto> toCountryDtoList(List<Country> countryList) {
        if ( countryList == null ) {
            return null;
        }

        List<CountryDto> list = new ArrayList<CountryDto>( countryList.size() );
        for ( Country country : countryList ) {
            list.add( toCountryDto( country ) );
        }

        return list;
    }

    @Override
    public Country createCountry(CreateUpdateCountryRequest request) {
        if ( request == null ) {
            return null;
        }

        CountryBuilder<?, ?> country = Country.builder();

        country.countryName( request.getCountryName() );

        return country.build();
    }

    @Override
    public void updateCountry(Country country, CreateUpdateCountryRequest request) {
        if ( request == null ) {
            return;
        }

        country.setCountryName( request.getCountryName() );
    }
}
