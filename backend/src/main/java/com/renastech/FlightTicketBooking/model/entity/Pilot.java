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
@Table(name = "pilots")
@SuperBuilder
public class Pilot {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false)
    private String pilotFirstName;

    @Column(unique = true,nullable = false)
    private String pilotLicence;

    @Column(nullable = false)
    private String pilotLastName;

    @Column(nullable = false,unique = true)
    private String pilotIdentityNumber;

    @Column(unique = true,nullable = false)
    private String pilotEmail;

    @Column(unique = true,nullable = false)
    private String pilotPhoneNumber;

    @Builder.Default
    private Boolean available = true;

    @OneToMany(mappedBy = "pilot",fetch = FetchType.LAZY)
    private List<Flight> flightList;

}
