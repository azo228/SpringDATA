package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.UserDto;
import com.example.springdatabasicdemo.models.User;
import com.example.springdatabasicdemo.services.CrudService;
import com.example.springdatabasicdemo.services.impl.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements CrudService<UserDto, Integer> {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDto register(UserDto entity) {
        if (entity.getId()!=null) {
            Optional<User> user = userRepo.findById(entity.getId());
            if (user.isPresent()) {
                UserDto dto = modelMapper.map(user,UserDto.class);
                entity.setCreated(dto.getCreated());
                entity.setModified(new Date());
                User u = modelMapper.map(entity, User.class);
                return modelMapper.map(userRepo.save(u), UserDto.class);
            }
        }
        entity.setCreated(new Date());
        User u = modelMapper.map(entity,User.class);
        return modelMapper.map(userRepo.save(u), UserDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public void delete(UserDto entity) {
        userRepo.deleteById(entity.getId());
    }

    @Override
    public List<UserDto> getAll() {
        return userRepo.findAll().stream().map((c)->modelMapper.map(c,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> getById(Integer id) {
        return Optional.ofNullable(modelMapper.map(userRepo.findById(id),UserDto.class));
    }
}
