package com.renastech.FlightTicketBooking.shared;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    @Constraint(validatedBy =UniqueUserEmailValidator.class)
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UniqueUserEmail {

        String message() default "This Email Has Been Used Already";

        Class<?>[] groups() default { };

        Class<? extends Payload>[] payload() default { };

    }

