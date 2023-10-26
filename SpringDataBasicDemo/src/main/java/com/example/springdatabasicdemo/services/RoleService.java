package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.UserRoleDto;

import java.util.List;

public interface RoleService<UUID> {

    UserRoleDto createRole(UserRoleDto role);

    List<UserRoleDto> getAllRoles();

    void deleteRole(UserRoleDto role);

    void deleteRoleById(UUID id);
}
