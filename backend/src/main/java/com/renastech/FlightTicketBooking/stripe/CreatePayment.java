package com.renastech.FlightTicketBooking.stripe;

import com.renastech.FlightTicketBooking.model.entity.Travellers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreatePayment {

    private Integer flightId;

    private Integer ticketNumber;

    private List<Travellers> travellers;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    private Integer userId;


}
