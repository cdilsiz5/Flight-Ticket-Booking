package com.renastech.FlightTicketBooking.repository;

import com.renastech.FlightTicketBooking.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {
}

