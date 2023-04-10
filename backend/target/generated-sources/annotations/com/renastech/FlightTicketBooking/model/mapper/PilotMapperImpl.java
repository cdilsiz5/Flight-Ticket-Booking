package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.PilotDto;
import com.renastech.FlightTicketBooking.model.dto.PilotDto.PilotDtoBuilder;
import com.renastech.FlightTicketBooking.model.entity.Pilot;
import com.renastech.FlightTicketBooking.model.entity.Pilot.PilotBuilder;
import com.renastech.FlightTicketBooking.model.request.CreateUpdatePilotRequest;
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
public class PilotMapperImpl implements PilotMapper {

    @Override
    public PilotDto toPilotDto(Pilot pilot) {
        if ( pilot == null ) {
            return null;
        }

        PilotDtoBuilder pilotDto = PilotDto.builder();

        if ( pilot.getId() != null ) {
            pilotDto.id( pilot.getId() );
        }
        pilotDto.pilotFirstName( pilot.getPilotFirstName() );
        pilotDto.pilotLicence( pilot.getPilotLicence() );
        pilotDto.pilotLastName( pilot.getPilotLastName() );
        pilotDto.pilotIdentityNumber( pilot.getPilotIdentityNumber() );
        pilotDto.pilotEmail( pilot.getPilotEmail() );
        pilotDto.pilotPhoneNumber( pilot.getPilotPhoneNumber() );
        if ( pilot.getAvailable() != null ) {
            pilotDto.available( pilot.getAvailable() );
        }

        return pilotDto.build();
    }

    @Override
    public List<PilotDto> toPilotDtoList(List<Pilot> pilotList) {
        if ( pilotList == null ) {
            return null;
        }

        List<PilotDto> list = new ArrayList<PilotDto>( pilotList.size() );
        for ( Pilot pilot : pilotList ) {
            list.add( toPilotDto( pilot ) );
        }

        return list;
    }

    @Override
    public Pilot createPilot(CreateUpdatePilotRequest request) {
        if ( request == null ) {
            return null;
        }

        PilotBuilder<?, ?> pilot = Pilot.builder();

        pilot.pilotFirstName( request.getPilotFirstName() );
        pilot.pilotLicence( request.getPilotLicence() );
        pilot.pilotLastName( request.getPilotLastName() );
        pilot.pilotIdentityNumber( request.getPilotIdentityNumber() );
        pilot.pilotEmail( request.getPilotEmail() );
        pilot.pilotPhoneNumber( request.getPilotPhoneNumber() );

        return pilot.build();
    }

    @Override
    public void updatePilot(Pilot pilot, CreateUpdatePilotRequest request) {
        if ( request == null ) {
            return;
        }

        pilot.setPilotFirstName( request.getPilotFirstName() );
        pilot.setPilotLicence( request.getPilotLicence() );
        pilot.setPilotLastName( request.getPilotLastName() );
        pilot.setPilotIdentityNumber( request.getPilotIdentityNumber() );
        pilot.setPilotEmail( request.getPilotEmail() );
        pilot.setPilotPhoneNumber( request.getPilotPhoneNumber() );
    }
}
