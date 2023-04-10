package com.renastech.FlightTicketBooking.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUpdateAddressRequest {

    private int cityId;

    private String address;

    private String addressRegion;

    private String addressPostalcode;

}
