package com.renastech.FlightTicketBooking.exception.handler;

import com.renastech.FlightTicketBooking.exception.ApiException;
import com.renastech.FlightTicketBooking.exception.TokenRefreshException;
import com.renastech.FlightTicketBooking.exception.ValidationException;
import com.renastech.FlightTicketBooking.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationException>  handleValidationException (MethodArgumentNotValidException exception){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ValidationException errorResponse= ValidationException.builder()
                .exceptionType(exception.getClass().getSimpleName())
                .validationErrors(validationErrors)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .errorTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }

  @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(ApiException exception){
        ErrorResponse errorResponse= ErrorResponse.builder()
                .message(exception.getMessage())
                .exceptionType(exception.getClass().getSimpleName())
                .statusCode(exception.getHttpStatus().value())
                .errorTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(exception.getHttpStatus()).body(errorResponse);
    }
    @ExceptionHandler(value = TokenRefreshException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorResponse>  handleTokenRefreshException(TokenRefreshException ex, WebRequest request) {
        ErrorResponse errorResponse= ErrorResponse.builder()
                .message(ex.getMessage())
                .exceptionType(ex.getClass().getSimpleName())
                .statusCode(ex.getHttpStatus().value())
                .errorTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(ex.getHttpStatus()).body(errorResponse);

    }
}



