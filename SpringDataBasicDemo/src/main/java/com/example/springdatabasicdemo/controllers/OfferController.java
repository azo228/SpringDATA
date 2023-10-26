package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.OfferDto;
import com.example.springdatabasicdemo.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OfferController {
    @Autowired
    CrudService<OfferDto,Integer> offerService;

    @PostMapping("/offers/update")
    OfferDto update(@RequestBody OfferDto offerDto){
        return offerService.register(offerDto);
    }

    @GetMapping("/offers")
    Iterable<OfferDto> all() {
        return offerService.getAll();
    }

    @PostMapping("/offers/register")
    OfferDto newBrand(@RequestBody OfferDto offerDto) {  return offerService.register(offerDto); }

    @GetMapping("/offers/{id}")
    Optional<OfferDto> oneBrand(@PathVariable Integer id) {
        return offerService.getById(id);
    }

    @DeleteMapping("/offers/{id}")
    void deleteBrands(@PathVariable Integer id) {
        offerService.deleteById(id);
    }
}
