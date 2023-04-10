package com.renastech.FlightTicketBooking.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
@Builder
@Data
public class ValidationException {
    private Map<String, String>  validationErrors;
    private int statusCode;
    private String exceptionType;
    private LocalDateTime errorTime;



}
