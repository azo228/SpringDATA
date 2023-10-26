package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.BrandDto;
import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.services.CrudService;
import com.example.springdatabasicdemo.services.impl.repositories.BrandRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements CrudService<BrandDto,Integer> {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BrandRepo brandRepo;

    @Override
    public BrandDto register(BrandDto entity) {
        if (entity.getId()!=null) {
            Optional<Brand> brand = brandRepo.findById(entity.getId());
            if (brand.isPresent()) {
                BrandDto dto = modelMapper.map(brand,BrandDto.class);
                entity.setCreated(dto.getCreated());
                entity.setModified(new Date());
                Brand b = modelMapper.map(entity, Brand.class);
                return modelMapper.map(brandRepo.save(b), BrandDto.class);
            }
        }
        entity.setCreated(new Date());
        Brand b = modelMapper.map(entity,Brand.class);
        return modelMapper.map(brandRepo.save(b), BrandDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        brandRepo.deleteById(id);
    }

    @Override
    public void delete(BrandDto entity) {
        brandRepo.deleteById(entity.getId());
    }

    @Override
    public List<BrandDto> getAll() {
        return brandRepo.findAll().stream().map((c)->modelMapper.map(c,BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<BrandDto> getById(Integer id) {
        return Optional.ofNullable(modelMapper.map(brandRepo.findById(id),BrandDto.class));
    }

}
