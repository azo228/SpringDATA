package com.example.springdatabasicdemo.services;
import com.example.springdatabasicdemo.dtos.UserDto;


import java.util.List;
import java.util.Optional;

public interface UserService<UUID> {

    UserDto registerUser(UserDto user);

    Optional<UserDto> getUserById(UUID id);


    void updateUserPassword(String userPassword, UUID id);

    void deleteUserById(UUID id);
}
