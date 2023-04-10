package com.renastech.FlightTicketBooking.repository;

import com.renastech.FlightTicketBooking.model.entity.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany,Integer> {
}
