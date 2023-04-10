package com.renastech.FlightTicketBooking.model.dto;


import com.renastech.FlightTicketBooking.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private int id;

    private String userFirstName;

    private String userLastName;

    private String userEmail;

    private String userPhoneNumber;

    private String userGender;

    private String userImage;

    private Set<Role> roles ;


}
