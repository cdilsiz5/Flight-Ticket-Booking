package com.renastech.FlightTicketBooking.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateFlightRequest {

    private String flightCode;

    private String departureDate;

    private String arrivalDate;

    private String departureTime;

    private String arrivalTime;

    private int pilotId;

    private int companyId;

    private int airplaneId;

    private int ticketPriceId;

    private int departureAirportId;

    private int arrivalAirportId;

}
