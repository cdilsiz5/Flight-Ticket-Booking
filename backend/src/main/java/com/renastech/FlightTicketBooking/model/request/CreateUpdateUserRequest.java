package com.renastech.FlightTicketBooking.model.request;

import com.renastech.FlightTicketBooking.model.enums.UserGender;
import com.renastech.FlightTicketBooking.shared.UniquePhoneNumber;
import com.renastech.FlightTicketBooking.shared.UniqueUserEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateUserRequest {

    @NotNull(message ="First Name Cannot Be Null")
    private String userFirstName;


    @NotNull(message ="Last Name Cannot Be Null")
    private String userLastName;


    @UniqueUserEmail
    @NotNull(message ="Email Cannot Be Null")
    @Email(message = "Please Enter Email Format")
    private String userEmail;

    @UniquePhoneNumber
    @NotNull(message ="Phone Number Cannot Be Null")
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$",message = "Please Enter Phone Number In Format")
    private String userPhoneNumber;

    @NotNull(message ="Password Cannot Be Null")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message="Minimum eight characters, at least one uppercase letter, one lowercase letter, one number ")
    private String userPassword;
    @Enumerated(EnumType.STRING)

    private UserGender userGender;

    private String userImage;



}
