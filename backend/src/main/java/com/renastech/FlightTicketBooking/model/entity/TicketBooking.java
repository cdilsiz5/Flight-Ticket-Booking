package com.renastech.FlightTicketBooking.model.entity;

import com.renastech.FlightTicketBooking.model.enums.UserGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang.enums.Enum;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket_bookings")
@SuperBuilder
public class TicketBooking extends BaseEntity{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "firstname" ,insertable = false ,updatable = false)
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Enumerated(EnumType.STRING)
    private UserGender userGender;

    @Column(name = "flight_id")
    private Integer flightId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id",insertable = false,updatable = false,nullable = false)
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false,updatable = false )
    private User users;

    @Column (name = "confirmation_number")
    private String confirmationNumber;



}
