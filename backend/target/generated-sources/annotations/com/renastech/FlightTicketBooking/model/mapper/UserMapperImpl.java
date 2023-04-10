package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.UserDto;
import com.renastech.FlightTicketBooking.model.dto.UserDto.UserDtoBuilder;
import com.renastech.FlightTicketBooking.model.entity.Role;
import com.renastech.FlightTicketBooking.model.entity.User;
import com.renastech.FlightTicketBooking.model.entity.User.UserBuilder;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateUserRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-10T21:31:15-0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        if ( user.getId() != null ) {
            userDto.id( user.getId() );
        }
        userDto.userFirstName( user.getUserFirstName() );
        userDto.userLastName( user.getUserLastName() );
        userDto.userEmail( user.getUserEmail() );
        userDto.userPhoneNumber( user.getUserPhoneNumber() );
        if ( user.getUserGender() != null ) {
            userDto.userGender( user.getUserGender().name() );
        }
        userDto.userImage( user.getUserImage() );
        Set<Role> set = user.getRoles();
        if ( set != null ) {
            userDto.roles( new HashSet<Role>( set ) );
        }

        return userDto.build();
    }

    @Override
    public List<UserDto> toUserDtoList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( userList.size() );
        for ( User user : userList ) {
            list.add( toUserDto( user ) );
        }

        return list;
    }

    @Override
    public User createUser(CreateUpdateUserRequest request) {
        if ( request == null ) {
            return null;
        }

        UserBuilder<?, ?> user = User.builder();

        user.userFirstName( request.getUserFirstName() );
        user.userLastName( request.getUserLastName() );
        user.userEmail( request.getUserEmail() );
        user.userPhoneNumber( request.getUserPhoneNumber() );
        user.userPassword( request.getUserPassword() );
        user.userGender( request.getUserGender() );
        user.userImage( request.getUserImage() );

        return user.build();
    }

    @Override
    public void updateUser(User user, CreateUpdateUserRequest request) {
        if ( request == null ) {
            return;
        }

        user.setUserFirstName( request.getUserFirstName() );
        user.setUserLastName( request.getUserLastName() );
        user.setUserEmail( request.getUserEmail() );
        user.setUserPhoneNumber( request.getUserPhoneNumber() );
        user.setUserPassword( request.getUserPassword() );
        user.setUserGender( request.getUserGender() );
        user.setUserImage( request.getUserImage() );
    }
}
