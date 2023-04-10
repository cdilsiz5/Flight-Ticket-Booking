package com.renastech.FlightTicketBooking.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flights")
@SuperBuilder
public class Flight extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(unique = true,nullable = false)
    private String flightCode;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column
    private LocalDate departureDate;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column
    private LocalDate arrivalDate;

    @Column(nullable = false, name="departure_time")
    private String departureTime;

    @Column(nullable = false)
    private String arrivalTime;

    @Column(name = "departure_airport_id")
    private Integer departureAirportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_airport_id",insertable = false,updatable = false,nullable = false)
    private Airport departureAirport;

    @Column(name = "arrival_airport_id")
    private Integer arrivalAirportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_airport_id",insertable = false,updatable = false,nullable = false)
    private Airport arrivalAirport;

    @Column(name = "pilot_id")
    private Integer pilotId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pilot_id",nullable = false,insertable = false,updatable = false)
    private Pilot pilot;

    @Column(name = "company_id")
    private Integer companyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id",nullable = false,insertable = false,updatable = false)
    private AirlineCompany company;

    @Column(name = "airplane_id")
    private Integer airplaneId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id",nullable = false,insertable = false,updatable = false)
    private Airplane airplane;

    @Column(name = "ticket_price_id")
    private Integer ticketPriceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_price_id",nullable = false,insertable = false,updatable = false)
    private TicketPrice ticketPrice;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "flight",cascade = CascadeType.ALL)
    private List<TicketBooking> ticketBookingList;

    @Builder.Default
    private Boolean available=true;

    @Column
    private Integer seatLeft;





}
