package com.renastech.FlightTicketBooking.model.entity;

import com.renastech.FlightTicketBooking.model.enums.UserGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@SuperBuilder
public class User  extends BaseEntity  {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;


    @Column(nullable = false)
    private String userFirstName;

    @Column(nullable = false)
    private String userLastName;

    @Column(unique = true,nullable = false)
    private String userEmail;

    @Column(unique = true,nullable = false)
    private String userPhoneNumber;

    @Column(unique = true,nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private UserGender userGender;

    @Column
    private String userImage;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "users")
    private List<TicketBooking> ticketBooking;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "users")
    private List<UserLog> userLogs;


}


