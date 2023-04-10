package com.renastech.FlightTicketBooking.shared;

import com.renastech.FlightTicketBooking.model.entity.User;
import com.renastech.FlightTicketBooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePhoneNumberValidator implements ConstraintValidator<UniquePhoneNumber,String> {
        @Autowired
        UserRepository userRepository;

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            User user = userRepository.findByUserPhoneNumber(s);
            if(user == null) {
                return true;
            }

            return false;
        }

}
