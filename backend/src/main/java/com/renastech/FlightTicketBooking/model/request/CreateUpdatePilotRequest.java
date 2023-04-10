package com.renastech.FlightTicketBooking.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateUpdatePilotRequest {
    private String pilotFirstName;

    private String pilotLicence;

    private String pilotLastName;

    private String pilotIdentityNumber;

    private String pilotEmail;

    private String pilotPhoneNumber;

 }
