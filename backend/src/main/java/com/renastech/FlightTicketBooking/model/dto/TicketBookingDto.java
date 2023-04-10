package com.renastech.FlightTicketBooking.model.dto;

import com.renastech.FlightTicketBooking.model.enums.UserGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketBookingDto {
    private int id;

    private int userId;

    private int flightId;

    private String firstname;

    private String lastname;

    private UserGender userGender;

 }
