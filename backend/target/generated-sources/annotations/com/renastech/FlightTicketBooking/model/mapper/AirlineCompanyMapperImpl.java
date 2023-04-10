package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.AirlineCompanyDto;
import com.renastech.FlightTicketBooking.model.dto.AirlineCompanyDto.AirlineCompanyDtoBuilder;
import com.renastech.FlightTicketBooking.model.entity.AirlineCompany;
import com.renastech.FlightTicketBooking.model.entity.AirlineCompany.AirlineCompanyBuilder;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateAirlineCompanyRequest;
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
public class AirlineCompanyMapperImpl implements AirlineCompanyMapper {

    @Override
    public AirlineCompanyDto toAirlaneCompanyDto(AirlineCompany airlineCompany) {
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

    @Override
    public List<AirlineCompanyDto> toAirlaneCompanyDtoList(List<AirlineCompany> airlineCompany) {
        if ( airlineCompany == null ) {
            return null;
        }

        List<AirlineCompanyDto> list = new ArrayList<AirlineCompanyDto>( airlineCompany.size() );
        for ( AirlineCompany airlineCompany1 : airlineCompany ) {
            list.add( toAirlaneCompanyDto( airlineCompany1 ) );
        }

        return list;
    }

    @Override
    public AirlineCompany createAirlineCompany(CreateUpdateAirlineCompanyRequest request) {
        if ( request == null ) {
            return null;
        }

        AirlineCompanyBuilder<?, ?> airlineCompany = AirlineCompany.builder();

        airlineCompany.companyName( request.getCompanyName() );
        airlineCompany.companyDetail( request.getCompanyDetail() );

        return airlineCompany.build();
    }

    @Override
    public void updateAirlineCompany(AirlineCompany airlineCompany, CreateUpdateAirlineCompanyRequest request) {
        if ( request == null ) {
            return;
        }

        airlineCompany.setCompanyName( request.getCompanyName() );
        airlineCompany.setCompanyDetail( request.getCompanyDetail() );
    }
}
