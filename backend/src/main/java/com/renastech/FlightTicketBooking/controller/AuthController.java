package com.renastech.FlightTicketBooking.controller;

import com.renastech.FlightTicketBooking.exception.TokenRefreshException;
import com.renastech.FlightTicketBooking.model.dto.UserDto;
import com.renastech.FlightTicketBooking.model.entity.RefreshToken;
import com.renastech.FlightTicketBooking.model.entity.Role;
import com.renastech.FlightTicketBooking.model.entity.User;
import com.renastech.FlightTicketBooking.model.entity.UserLog;
import com.renastech.FlightTicketBooking.model.enums.UserGender;
import com.renastech.FlightTicketBooking.model.enums.UserRole;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateUserRequest;
import com.renastech.FlightTicketBooking.model.request.LoginRequest;
import com.renastech.FlightTicketBooking.model.request.TokenRefreshRequest;
import com.renastech.FlightTicketBooking.model.response.JwtResponse;
import com.renastech.FlightTicketBooking.model.response.TokenRefreshResponse;
import com.renastech.FlightTicketBooking.repository.RoleRepository;
import com.renastech.FlightTicketBooking.repository.UserLogRepository;
import com.renastech.FlightTicketBooking.repository.UserRepository;
import com.renastech.FlightTicketBooking.security.jwt.JwtUtils;
import com.renastech.FlightTicketBooking.security.services.RefreshTokenService;
import com.renastech.FlightTicketBooking.security.services.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static com.renastech.FlightTicketBooking.model.mapper.UserMapper.USER_MAPPER;

@CrossOrigin
@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserLogRepository userLogRepository;

    private final AuthenticationManager authenticationManager;


    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;
    private final RefreshTokenService refreshTokenService;

    private final JwtUtils jwtUtils;
    @PostMapping("/login")
    public ResponseEntity<?> Login( @RequestBody LoginRequest request){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserEmail(), request.getUserPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(userDetails);

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

        User user = userRepository.findByUserEmail(request.getUserEmail());
        userLogRepository.save(new UserLog(null,user.getId(),null, LocalDateTime.now()));
        return ResponseEntity.ok(new JwtResponse(jwt,refreshToken.getToken(),USER_MAPPER.toUserDto(user)));
    }
    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUserEmail());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }
    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = userDetails.getId();
        refreshTokenService.deleteByUserId(userId);
        return ResponseEntity.ok("Log out successful!");
    }
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto signup(@Valid @RequestBody CreateUpdateUserRequest request){
             User user =USER_MAPPER.createUser(request);
            if(request.getUserGender().toString().equals("MALE")){
                user.setUserGender(UserGender.MALE);
            } else if (request.getUserGender().toString().equals("FEMALE")) {
                user.setUserGender(UserGender.FEMALE);
            }else {
                user.setUserGender(UserGender.OTHERS);
            }
            user.setUserPassword(passwordEncoder.encode(request.getUserPassword()));
            Role userRole = roleRepository.findByUserRoleEquals(UserRole.ROLE_ADMIN).orElseThrow(()->new RuntimeException("xd"));
            Set<Role> roles = new HashSet<>();
            roles.add(userRole);
            user.setRoles(roles);

            return USER_MAPPER.toUserDto(userRepository.save(user));
        }
    }


