package com.renastech.FlightTicketBooking.controller;

import com.renastech.FlightTicketBooking.model.dto.CountryDto;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateCountryRequest;
import com.renastech.FlightTicketBooking.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService service;
    //@PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CountryDto createCountry(@RequestBody CreateUpdateCountryRequest request){
        return service.createCountry(request);
    }
    @GetMapping("{id}")
    public CountryDto getCountry(@PathVariable int id) {
        return service.getCountryById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("{id}")
    public CountryDto updateCountry(@PathVariable int id, @RequestBody CreateUpdateCountryRequest request){
        return service.updateCountry(id,request);
    }

    @GetMapping
    public List<CountryDto> getCountryList() {
        return service.getCountryList();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCountry(@PathVariable  int id){
        service.deleteCountry(id);
    }
}
