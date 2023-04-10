package com.renastech.FlightTicketBooking.repository;

import com.renastech.FlightTicketBooking.model.entity.Role;
import com.renastech.FlightTicketBooking.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByUserRoleEquals(UserRole name);
}