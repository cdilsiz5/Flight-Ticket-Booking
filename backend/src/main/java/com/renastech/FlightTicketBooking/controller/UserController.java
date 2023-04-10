package com.renastech.FlightTicketBooking.controller;

import com.renastech.FlightTicketBooking.model.dto.UserDto;
import com.renastech.FlightTicketBooking.model.request.UpdateUserRequest;
import com.renastech.FlightTicketBooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/Users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService service;

    @GetMapping("{id}")
    public UserDto getUser(@PathVariable int id) {
        return service.getUserById(id);
    }


    @PutMapping("/{id:[0-9]+}")
    public UserDto updateUser(@PathVariable int id, @RequestBody UpdateUserRequest request){
        return service.updateUser(id,request);

    }

    @GetMapping
    public List<UserDto> getUserList() {
        return service.getUserList();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable  int id){
        service.deleteUser(id);
    }





}
