package com.renastech.FlightTicketBooking.service;

import com.renastech.FlightTicketBooking.exception.BussinesException;
import com.renastech.FlightTicketBooking.exception.NotFoundException;
import com.renastech.FlightTicketBooking.model.dto.CityDto;
import com.renastech.FlightTicketBooking.model.entity.City;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateCityRequest;
import com.renastech.FlightTicketBooking.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.renastech.FlightTicketBooking.model.mapper.CityMapper.CITY_MAPPER;


@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository repository;

    public CityDto createCity(CreateUpdateCityRequest request){
        City city=CITY_MAPPER.createCity(request);
        return CITY_MAPPER.toCityDto(repository.save(city));
    }
    public CityDto updateCity(int id,CreateUpdateCityRequest request){
       City city=repository.findById(id).orElseThrow(()->new BussinesException("City is not found."));
        CITY_MAPPER.updateCity(city,request);
       City updatedcity=repository.save(city);
        return CITY_MAPPER.toCityDto(updatedcity);
    }
    public CityDto getCityById(int id){
        return CITY_MAPPER.toCityDto(repository.findById(id).orElseThrow(()-> new NotFoundException("City  not found.")));
    }
    public List<CityDto> getCityList(){
        return  CITY_MAPPER.toCityDtoList(repository.findAll());
    }
    public void deleteCity(int id){
        repository.deleteById(id);
    }

    public City findByCityName(String cityName){
        City city=repository.findByCityName(cityName).orElseThrow(()->new BussinesException("Cannot find City"));
        return city;
    }
}
