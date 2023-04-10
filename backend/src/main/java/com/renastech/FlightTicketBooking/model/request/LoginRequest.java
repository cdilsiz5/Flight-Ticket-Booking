package com.renastech.FlightTicketBooking.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {
    @NotBlank
    private String userEmail;

    @NotBlank
    private String userPassword;

}
