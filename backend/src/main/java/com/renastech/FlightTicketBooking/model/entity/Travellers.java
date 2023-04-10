package com.renastech.FlightTicketBooking.model.entity;

import com.renastech.FlightTicketBooking.model.enums.UserGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Travellers {
    private String firstname;

    private String lastname;

    private UserGender userGender;
}
