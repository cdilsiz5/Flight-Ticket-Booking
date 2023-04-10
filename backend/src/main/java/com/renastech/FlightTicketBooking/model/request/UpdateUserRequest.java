package com.renastech.FlightTicketBooking.model.request;

import com.renastech.FlightTicketBooking.model.enums.UserGender;
import com.renastech.FlightTicketBooking.shared.ProfileImage;
import com.renastech.FlightTicketBooking.shared.UniquePhoneNumber;
import com.renastech.FlightTicketBooking.shared.UniqueUserEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequest {


    @UniqueUserEmail
    @NotNull(message ="Email Cannot Be Null")
    @Email(message = "Please Enter Email Format")
    private String userEmail;

    @UniquePhoneNumber
    @NotNull(message ="Phone Number Cannot Be Null")
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$",message = "Please Enter Phone Number Format")
    private String userPhoneNumber;

    private UserGender userGender;

    @ProfileImage
    private String userImage;
}
