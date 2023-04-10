package com.renastech.FlightTicketBooking.controller;

import com.renastech.FlightTicketBooking.model.dto.AddressDto;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateAddressRequest;
import com.renastech.FlightTicketBooking.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService service;

    @GetMapping("{id}")
    public AddressDto getAddress(@PathVariable int id) {
        return service.getAddressById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDto createAddress(@Valid @RequestBody CreateUpdateAddressRequest request){
        return service.createAddress(request);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("{id}")
    public AddressDto updateAddress(@PathVariable int id, @RequestBody CreateUpdateAddressRequest request){
        return service.updateAddress(id,request);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<AddressDto> getAddressList() {
        return service.getAddressList();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable  int id){
        service.deleteAddress(id);
    }
}
