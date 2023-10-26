package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ModelDto;
import com.example.springdatabasicdemo.models.Model;
import com.example.springdatabasicdemo.services.CrudService;
import com.example.springdatabasicdemo.services.impl.repositories.ModelRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements CrudService<ModelDto,Integer> {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ModelRepo modelRepo;

    @Override
    public ModelDto register(ModelDto entity) {
        if (entity.getId()!=null) {
            Optional<Model> model = modelRepo.findById(entity.getId());
            if (model.isPresent()) {
                ModelDto dto = modelMapper.map(model,ModelDto.class);
                entity.setCreated(dto.getCreated());
                entity.setModified(new Date());
                Model m = modelMapper.map(entity, Model.class);
                return modelMapper.map(modelRepo.save(m), ModelDto.class);
            }
        }
        entity.setCreated(new Date());
        Model m = modelMapper.map(entity,Model.class);
        return modelMapper.map(modelRepo.save(m), ModelDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        modelRepo.deleteById(id);
    }

    @Override
    public void delete(ModelDto entity) {
        modelRepo.deleteById(entity.getId());
    }

    @Override
    public List<ModelDto> getAll() {
        return modelRepo.findAll().stream().map((c)->modelMapper.map(c,ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ModelDto> getById(Integer id) {
        return Optional.ofNullable(modelMapper.map(modelRepo.findById(id),ModelDto.class));
    }
}
