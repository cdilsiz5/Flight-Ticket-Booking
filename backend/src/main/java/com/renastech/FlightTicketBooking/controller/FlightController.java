package com.renastech.FlightTicketBooking.controller;

import com.renastech.FlightTicketBooking.model.dto.FlightDto;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateFlightRequest;
import com.renastech.FlightTicketBooking.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService service;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public FlightDto createFlight(@RequestBody CreateUpdateFlightRequest request){
        return service.createFlight(request);
    }
    @GetMapping("{id}")
    public FlightDto getFlight(@PathVariable int id) {
        return service.getFlightById(id);
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("{id}")
    public FlightDto updateFlight(@PathVariable int id, @RequestBody CreateUpdateFlightRequest request){
        return service.updateFlight(id,request);
    }

    @GetMapping
    public List<FlightDto> getFlightList() {
        return service.getAvailableFlightList();
    }

    @GetMapping("/searchFlight")
    public List<FlightDto> searchFlight(@RequestParam String from,String to,int ticketNumber,String depDate) {
        return service.searchFlight(from ,to,ticketNumber,depDate);
    }
     
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFlight(@PathVariable  int id){
        service.deleteFlight(id);
    }
}
