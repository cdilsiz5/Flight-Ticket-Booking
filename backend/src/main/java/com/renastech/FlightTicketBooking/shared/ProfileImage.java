package com.renastech.FlightTicketBooking.shared;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ProfileImageValidator.class})
public @interface ProfileImage {
    String message () default "Unsupported Image Type";
    Class<?>[] groups () default {};
    Class < ? extends Payload> [] payload () default {};
}
