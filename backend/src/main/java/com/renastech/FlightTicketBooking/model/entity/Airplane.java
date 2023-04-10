package com.renastech.FlightTicketBooking.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "airplanes")
@SuperBuilder
public class Airplane extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false,unique = true)
    private String airplaneName;

    @Column
    private Integer airplaneCapacity;

    @Column
    private String airplaneManufacturer;

    @Builder.Default
    private Boolean available = true;

    @Column(columnDefinition = "Text")
    private String airplaneDetails;

    @OneToMany(mappedBy = "airplane",fetch = FetchType.LAZY)
    private List<Flight> flightList;


}
