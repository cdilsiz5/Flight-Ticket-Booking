package com.renastech.FlightTicketBooking.repository;

import com.renastech.FlightTicketBooking.model.entity.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLogRepository extends JpaRepository<UserLog, Integer> {
}
