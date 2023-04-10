package com.renastech.FlightTicketBooking.repository;

import com.renastech.FlightTicketBooking.model.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AirplaneRepository extends JpaRepository<Airplane,Integer> {
    @Modifying(clearAutomatically = true)
    @Query("update #{#entityName} a set a.available= :available where a.id= :id")
    int setAvailable(@Param("id") Integer id, @Param("available") boolean available);
}
