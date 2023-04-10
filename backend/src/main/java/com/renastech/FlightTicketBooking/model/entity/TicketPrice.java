package com.renastech.FlightTicketBooking.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket_price")
@SuperBuilder
public class TicketPrice extends BaseEntity{
    @GeneratedValue
    @Id
    private Integer id;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "ticketPrice",cascade = CascadeType.ALL)
    private List<Flight> flights;

    @Min(1)
    @Column(nullable = false)
    private Double amount;



}
