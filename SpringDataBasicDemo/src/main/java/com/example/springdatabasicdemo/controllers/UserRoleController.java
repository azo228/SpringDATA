package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.UserRoleDto;
import com.example.springdatabasicdemo.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserRoleController {

    @Autowired
    CrudService<UserRoleDto,Integer> userRoleService;

    @PostMapping("/userRoles/update")
    UserRoleDto update(@RequestBody UserRoleDto userRoleDto){
        return userRoleService.register(userRoleDto);
    }

    @GetMapping("/userRoles")
    Iterable<UserRoleDto> all() {
        return userRoleService.getAll();
    }

    @PostMapping("/userRoles/register")
    UserRoleDto newUserRole(@RequestBody UserRoleDto userRoleDto) {  return userRoleService.register(userRoleDto); }

    @GetMapping("/userRoles/{id}")
    Optional<UserRoleDto> oneUserRole(@PathVariable Integer id) {
        return userRoleService.getById(id);
    }

    @DeleteMapping("/userRoles/{id}")
    void deleteUserRoles(@PathVariable Integer id) {
        userRoleService.deleteById(id);
    }
}
