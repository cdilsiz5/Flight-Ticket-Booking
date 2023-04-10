package com.renastech.FlightTicketBooking.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityDto {
    private int id;

    private String cityName;

    private int  countryId;
}
