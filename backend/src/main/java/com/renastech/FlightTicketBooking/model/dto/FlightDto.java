package com.renastech.FlightTicketBooking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDto {
    private int id;

    private String flightCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalDate;

    private String departureTime;

    private String arrivalTime;
    private int pilotId;

    private int airlineCompanyId;

    private int airplaneId;

    private int ticketPriceId;

    private boolean available;

    private int seatLeft;

    private int departureAirportId;

    private int arrivalAirportId;

    private AirportDto departureAirport;

    private TicketPriceDto ticketPrice;

    private AirportDto arrivalAirport;

    private AirlineCompanyDto company;

}
