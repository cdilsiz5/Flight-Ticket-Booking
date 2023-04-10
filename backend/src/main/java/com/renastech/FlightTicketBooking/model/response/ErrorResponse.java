package com.renastech.FlightTicketBooking.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorResponse {
    private String message;
    private String exceptionType;
    private int statusCode;
    private LocalDateTime errorTime;


}
