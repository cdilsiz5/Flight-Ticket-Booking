package com.renastech.FlightTicketBooking.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
@SuperBuilder

public class Address extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "city_id")
    private Integer cityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id",insertable = false,updatable = false,nullable = false)
    private City city;

    @Column(columnDefinition="Text")
    private String address;

    @Column(nullable = false)
    @Size(max = 255,min = 4)
    private String addressRegion;

    @Column (nullable = false)
    private String addressPostalcode;



}
