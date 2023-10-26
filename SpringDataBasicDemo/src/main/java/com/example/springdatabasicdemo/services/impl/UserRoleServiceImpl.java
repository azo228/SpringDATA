package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.UserRoleDto;
import com.example.springdatabasicdemo.models.UserRole;
import com.example.springdatabasicdemo.services.CrudService;
import com.example.springdatabasicdemo.services.impl.repositories.UserRoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements CrudService<UserRoleDto,Integer> {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRoleRepo userRoleRepo;

    @Override
    public UserRoleDto register(UserRoleDto entity) {
        UserRole b = modelMapper.map(entity,UserRole.class);
        return modelMapper.map(userRoleRepo.save(b), UserRoleDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        userRoleRepo.deleteById(id);
    }

    @Override
    public void delete(UserRoleDto entity) {
        userRoleRepo.deleteById(entity.getId());
    }

    @Override
    public List<UserRoleDto> getAll() {
        return userRoleRepo.findAll().stream().map((c)->modelMapper.map(c,UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<UserRoleDto> getById(Integer id) {
        return Optional.ofNullable(modelMapper.map(userRoleRepo.findById(id),UserRoleDto.class));
    }
}
