package com.renastech.FlightTicketBooking.shared;

import com.renastech.FlightTicketBooking.file.FileService;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@RequiredArgsConstructor
public class ProfileImageValidator implements ConstraintValidator<ProfileImage,String> {

    private final FileService fileService ;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s==null||s.isEmpty()){
            return true;
        }
        String fileType=fileService.detectType(s);
        if(fileType.equalsIgnoreCase("image/jpeg")||fileType.equalsIgnoreCase("image/png")) {
            return true;
        }
        return false;

    }
}
