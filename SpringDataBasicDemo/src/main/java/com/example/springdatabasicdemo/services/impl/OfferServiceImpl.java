package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.OfferDto;
import com.example.springdatabasicdemo.models.Offer;
import com.example.springdatabasicdemo.services.CrudService;
import com.example.springdatabasicdemo.services.impl.repositories.OfferRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements CrudService<OfferDto,Integer> {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    OfferRepo offerRepo;

    @Override
    public OfferDto register(OfferDto entity) {
        if (entity.getId()!=null) {
            Optional<Offer> offer = offerRepo.findById(entity.getId());
            if (offer.isPresent()) {
                OfferDto dto = modelMapper.map(offer,OfferDto.class);
                entity.setCreated(dto.getCreated());
                entity.setModified(new Date());
                Offer o = modelMapper.map(entity, Offer.class);
                return modelMapper.map(offerRepo.save(o), OfferDto.class);
            }
        }
        entity.setCreated(new Date());
        Offer o = modelMapper.map(entity,Offer.class);
        return modelMapper.map(offerRepo.save(o), OfferDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        offerRepo.deleteById(id);
    }

    @Override
    public void delete(OfferDto entity) {
        offerRepo.deleteById(entity.getId());
    }

    @Override
    public List<OfferDto> getAll() {
        return offerRepo.findAll().stream().map((c)->modelMapper.map(c,OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<OfferDto> getById(Integer id) {
        return Optional.ofNullable(modelMapper.map(offerRepo.findById(id),OfferDto.class));
    }
}
