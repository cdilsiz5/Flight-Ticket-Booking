package com.renastech.FlightTicketBooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class TokenRefreshException extends ApiException {

    private static final long serialVersionUID = 1L;

    public TokenRefreshException(String token, String message) {
        super(message,HttpStatus.FORBIDDEN);
    }
}