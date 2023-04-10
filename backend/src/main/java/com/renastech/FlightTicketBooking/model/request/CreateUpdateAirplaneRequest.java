package com.renastech.FlightTicketBooking.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUpdateAirplaneRequest {
    private String airplaneName;

    private Integer airplaneCapacity;

    private String airplaneManufacturer;

    private String airplaneDetails;


 }
