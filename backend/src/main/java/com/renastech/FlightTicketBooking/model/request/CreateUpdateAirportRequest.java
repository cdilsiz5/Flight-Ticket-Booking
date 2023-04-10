package com.renastech.FlightTicketBooking.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateAirportRequest {
    private String name;

    private String details;

    private int gateCapacity;

    private int cityId;

    private String cityCode;
}
