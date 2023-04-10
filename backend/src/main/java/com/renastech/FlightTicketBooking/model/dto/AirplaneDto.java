package com.renastech.FlightTicketBooking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirplaneDto {
    private int id;

    private String airplaneName;

    private int  airplaneCapacity;

    private String airplaneManufacturer;

    private String airplaneDetails;

    private boolean available;


}
