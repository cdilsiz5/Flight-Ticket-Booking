package com.renastech.FlightTicketBooking.repository;

import com.renastech.FlightTicketBooking.model.entity.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketPriceRepository extends JpaRepository<TicketPrice,Integer> {
}
