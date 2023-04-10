package com.renastech.FlightTicketBooking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RotationDto {

    private Integer id;

    private int departureAirportId;

    private int arrivalAirportId;


}
