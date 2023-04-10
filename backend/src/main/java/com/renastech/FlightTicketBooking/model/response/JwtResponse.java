package com.renastech.FlightTicketBooking.model.response;

import com.renastech.FlightTicketBooking.model.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {
    private String accessToken;
    private String type = "Bearer";
    private String refreshToken;
    private UserDto userDto;

    public JwtResponse(String accessToken, String refreshToken , UserDto userDto) {
        this.accessToken = accessToken;
        this.userDto=userDto;
        this.refreshToken=refreshToken;
    }
}