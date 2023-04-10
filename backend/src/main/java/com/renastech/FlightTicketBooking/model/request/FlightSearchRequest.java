package com.renastech.FlightTicketBooking.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightSearchRequest {

    private String from;

    private String to;

    private String depDate;

    private int ticketNumber;

}
