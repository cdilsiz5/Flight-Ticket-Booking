package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.AirplaneDto;
import com.renastech.FlightTicketBooking.model.dto.AirplaneDto.AirplaneDtoBuilder;
import com.renastech.FlightTicketBooking.model.entity.Airplane;
import com.renastech.FlightTicketBooking.model.entity.Airplane.AirplaneBuilder;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateAirplaneRequest;
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
public class AirplaneMapperImpl implements AirplaneMapper {

    @Override
    public AirplaneDto toAirplaneDto(Airplane airplane) {
        if ( airplane == null ) {
            return null;
        }

        AirplaneDtoBuilder airplaneDto = AirplaneDto.builder();

        if ( airplane.getId() != null ) {
            airplaneDto.id( airplane.getId() );
        }
        airplaneDto.airplaneName( airplane.getAirplaneName() );
        if ( airplane.getAirplaneCapacity() != null ) {
            airplaneDto.airplaneCapacity( airplane.getAirplaneCapacity() );
        }
        airplaneDto.airplaneManufacturer( airplane.getAirplaneManufacturer() );
        airplaneDto.airplaneDetails( airplane.getAirplaneDetails() );
        if ( airplane.getAvailable() != null ) {
            airplaneDto.available( airplane.getAvailable() );
        }

        return airplaneDto.build();
    }

    @Override
    public List<AirplaneDto> toAirplaneDtoList(List<Airplane> airplaneList) {
        if ( airplaneList == null ) {
            return null;
        }

        List<AirplaneDto> list = new ArrayList<AirplaneDto>( airplaneList.size() );
        for ( Airplane airplane : airplaneList ) {
            list.add( toAirplaneDto( airplane ) );
        }

        return list;
    }

    @Override
    public Airplane createAirplane(CreateUpdateAirplaneRequest request) {
        if ( request == null ) {
            return null;
        }

        AirplaneBuilder<?, ?> airplane = Airplane.builder();

        airplane.airplaneName( request.getAirplaneName() );
        airplane.airplaneCapacity( request.getAirplaneCapacity() );
        airplane.airplaneManufacturer( request.getAirplaneManufacturer() );
        airplane.airplaneDetails( request.getAirplaneDetails() );

        return airplane.build();
    }

    @Override
    public void updateAirplane(Airplane airplane, CreateUpdateAirplaneRequest request) {
        if ( request == null ) {
            return;
        }

        airplane.setAirplaneName( request.getAirplaneName() );
        airplane.setAirplaneCapacity( request.getAirplaneCapacity() );
        airplane.setAirplaneManufacturer( request.getAirplaneManufacturer() );
        airplane.setAirplaneDetails( request.getAirplaneDetails() );
    }
}
