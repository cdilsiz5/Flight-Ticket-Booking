package com.renastech.FlightTicketBooking.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
@SuperBuilder
public class  City extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false)
    private String cityName;

    @Column(name = "country_id")
    private Integer countryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id",insertable = false,updatable = false,nullable = false)
    private Country country;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "cities")
    private List<Airport>CityList;


}
