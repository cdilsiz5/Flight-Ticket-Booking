package com.renastech.FlightTicketBooking.service;

import com.renastech.FlightTicketBooking.exception.BussinesException;
import com.renastech.FlightTicketBooking.exception.NotFoundException;
import com.renastech.FlightTicketBooking.model.dto.CountryDto;
import com.renastech.FlightTicketBooking.model.entity.Country;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateCountryRequest;
import com.renastech.FlightTicketBooking.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.renastech.FlightTicketBooking.model.mapper.CountryMapper.COUNTRY_MAPPER;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository repository;

    public CountryDto createCountry(CreateUpdateCountryRequest request){
        Country country=COUNTRY_MAPPER.createCountry(request);
        return COUNTRY_MAPPER.toCountryDto(repository.save(country));
    }
    public CountryDto updateCountry(int id,CreateUpdateCountryRequest request){
        Country country=repository.findById(id).orElseThrow(()->new BussinesException("Country is not found."));
        COUNTRY_MAPPER.updateCountry(country,request);
        Country updatedcountry=repository.save(country);
        return COUNTRY_MAPPER.toCountryDto(updatedcountry);
    }
    public CountryDto getCountryById(int id){
        return COUNTRY_MAPPER.toCountryDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Country   not found.")));
    }
    public List<CountryDto> getCountryList(){
        return  COUNTRY_MAPPER.toCountryDtoList(repository.findAll());
    }
    public void deleteCountry(int id){
        repository.deleteById(id);
    }
}
