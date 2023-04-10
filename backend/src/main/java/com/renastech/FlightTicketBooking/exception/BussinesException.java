package com.renastech.FlightTicketBooking.exception;

import org.springframework.http.HttpStatus;

public class BussinesException extends ApiException{

    public BussinesException(String message){
        super(message, HttpStatus.BAD_REQUEST);

    }
}
