package com.renastech.FlightTicketBooking.controller;

import com.renastech.FlightTicketBooking.model.dto.AirlineCompanyDto;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateAirlineCompanyRequest;
import com.renastech.FlightTicketBooking.service.AirlineCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/airlinecompanies")
@RequiredArgsConstructor
public class AirlineCompanyController {
    private final AirlineCompanyService service;
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirlineCompanyDto createAirlineCompany(@RequestBody CreateUpdateAirlineCompanyRequest request){
        return service.createAirlineCompany(request);
    }
    @GetMapping("{id}")
    public AirlineCompanyDto getAirlineCompany(@PathVariable int id) {
        return service.getAirlineCompanyById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping("{id}")
    public AirlineCompanyDto updateAirlineCompany(@PathVariable int id, @RequestBody CreateUpdateAirlineCompanyRequest request){
        return service.updateAirlineCompany(id,request);
    }
    @GetMapping
    public List<AirlineCompanyDto> getAirlineCompanyList() {
        return service.getAirlineCompanyList();
    }



    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAirlineCompany(@PathVariable  int id){
        service.deleteAirlineCompany(id);
    }
}
