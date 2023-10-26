package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.UserDto;
import com.example.springdatabasicdemo.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    CrudService<UserDto,Integer> userService;

    @PostMapping("/users/update")
    UserDto update(@RequestBody UserDto userDto){
        return userService.register(userDto);
    }

    @GetMapping("/users")
    Iterable<UserDto> all() {
        return userService.getAll();
    }

    @PostMapping("/users/register")
    UserDto newUser(@RequestBody UserDto userDto) {  return userService.register(userDto); }

    @GetMapping("/users/{id}")
    Optional<UserDto> oneUser(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @DeleteMapping("/users/{id}")
    void deleteBrands(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
