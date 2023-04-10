package com.renastech.FlightTicketBooking.repository;

import com.renastech.FlightTicketBooking.model.entity.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketBookingRepository extends JpaRepository<TicketBooking,Integer> {
    List<TicketBooking> findByFlightId(int id) ;
    List<TicketBooking> findByConfirmationNumber(String confimationNumber);
}
