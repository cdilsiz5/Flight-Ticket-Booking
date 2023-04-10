package com.renastech.FlightTicketBooking.controller;

import com.renastech.FlightTicketBooking.model.dto.AirplaneDto;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateAirplaneRequest;
import com.renastech.FlightTicketBooking.service.AirplaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/airplanes")
@RequiredArgsConstructor
public class AirplaneController {
    private final AirplaneService service;
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirplaneDto createAirplane(@RequestBody CreateUpdateAirplaneRequest request){
        return service.createAirplane(request);
    }
    @GetMapping("{id}")
    public AirplaneDto getAirplane(@PathVariable int id) {
        return service.getAirplaneById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("{id}")
    public AirplaneDto updateAirplane(@PathVariable int id, @RequestBody CreateUpdateAirplaneRequest request){
        return service.updateAirplane(id,request);
    }

    @GetMapping
    public List<AirplaneDto> getAirplaneList() {
        return service.getAirplaneList();
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAirplane(@PathVariable  int id){
        service.deleteAirplane(id);
    }
}
