package com.renastech.FlightTicketBooking.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PilotDto {

    private int id;

    private String pilotFirstName;

    private String pilotLicence;

    private String pilotLastName;

    private String pilotIdentityNumber;

    private String pilotEmail;

    private String pilotPhoneNumber;

    private boolean available;



}
