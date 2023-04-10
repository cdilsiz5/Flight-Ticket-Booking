package com.renastech.FlightTicketBooking.model.request;

import com.renastech.FlightTicketBooking.model.entity.Travellers;
import com.renastech.FlightTicketBooking.model.enums.UserGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateTicketBookingRequest {
    private int userId;

   private ArrayList<Travellers> list;

    private int flightId;


}
