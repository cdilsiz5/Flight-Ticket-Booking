package com.renastech.FlightTicketBooking.controller;

import com.renastech.FlightTicketBooking.model.dto.TicketBookingDto;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateTicketBookingRequest;
import com.renastech.FlightTicketBooking.service.TicketBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ticketbookings")
@RequiredArgsConstructor
public class TicketBookingController {
    private final TicketBookingService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createTicketBooking(@RequestBody CreateUpdateTicketBookingRequest request){
        return service.createTicketBooking(request);
    }


    @GetMapping("/confirmation")
    public  List<TicketBookingDto> getTicketBookingByConfirmationNumber(@RequestParam  String confirmationNumber){
       return service.getTicketBookingByConfirmationNumber(confirmationNumber);
    }
    @GetMapping
    public List<TicketBookingDto> getTicketBookingList() {
        return service.getTicketBookingList();
    }

    @DeleteMapping("{confirmationNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicketBooking(@PathVariable  String confirmationNumber){
        service.deleteTicketBooking(confirmationNumber);
    }
}
