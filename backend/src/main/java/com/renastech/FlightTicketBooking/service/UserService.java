package com.renastech.FlightTicketBooking.service;

import com.renastech.FlightTicketBooking.exception.NotFoundException;
import com.renastech.FlightTicketBooking.file.FileService;
import com.renastech.FlightTicketBooking.model.dto.UserDto;
import com.renastech.FlightTicketBooking.model.entity.User;
import com.renastech.FlightTicketBooking.model.request.UpdateUserRequest;
import com.renastech.FlightTicketBooking.repository.UserRepository;
import com.renastech.FlightTicketBooking.security.services.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

import static com.renastech.FlightTicketBooking.model.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository repository;

    private final FileService fileService;



    public UserDto updateUser(int id, UpdateUserRequest request){
        User user =repository.findById(id).orElseThrow(()->new NotFoundException("User not found."));
        if(request.getUserGender()!=null) {
            user.setUserGender(request.getUserGender());
        }
        if(request.getUserPhoneNumber()!=null) {
            user.setUserPhoneNumber(request.getUserPhoneNumber());
        }
        if(request.getUserEmail()!=null) {
            user.setUserEmail(request.getUserEmail());
        }
        if(request.getUserImage()!=null){
            String oldImageName=user.getUserImage();
            try {
                String storedFileName= fileService.writeBase64EncodedStringToFile(request.getUserImage());
                System.out.println(storedFileName);
                user.setUserImage(storedFileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            fileService.deleteFile(oldImageName);
        }
        User updatedUser =repository.save(user);
        return USER_MAPPER.toUserDto(updatedUser);
    }

    public UserDto getUserById(int id){
        return USER_MAPPER.toUserDto(repository.findById(id).orElseThrow(()-> new NotFoundException("User not found.")));
    }

    public List<UserDto> getUserList(){
        return  USER_MAPPER.toUserDtoList(repository.findAll());
    }

    public void deleteUser(int id){
        repository.deleteById(id);
    }



        @Override
        @Transactional
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            return UserDetailsImpl.build(repository.findByUserEmail(email));
        }

    }

