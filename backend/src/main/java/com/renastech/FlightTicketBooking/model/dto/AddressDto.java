package com.renastech.FlightTicketBooking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
    private int id;

    private int cityId;

    private String address;

    private String addressRegion;

    private String addressPostalcode;

}
