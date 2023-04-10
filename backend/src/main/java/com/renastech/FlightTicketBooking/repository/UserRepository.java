package com.renastech.FlightTicketBooking.repository;

import com.renastech.FlightTicketBooking.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


    User findByUserEmail(String email);
    User findByUserPhoneNumber(String number);
//    @Modifying
//    @Query("update User u set u.userEmail = :userEmail , u.userImage = :image , u.userPhoneNumber =:userPhoneNumber where u.id= :id")
//    void setUser(@Param("id") Integer id, @Param("userEmail") String  userEmail,@Param("userPhoneNumber") String userPhoneNumber,@Param("userImage") String userImage);
}
