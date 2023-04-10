package com.renastech.FlightTicketBooking.repository;

import com.renastech.FlightTicketBooking.model.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport,Integer> {
    Airport findAirportByCityCode(String name);
}
