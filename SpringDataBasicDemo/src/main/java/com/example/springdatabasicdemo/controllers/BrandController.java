package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.BrandDto;
import com.example.springdatabasicdemo.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BrandController {
    @Autowired
    CrudService<BrandDto,Integer> brandService;

    @PostMapping("/brands/update")
    BrandDto update(@RequestBody BrandDto brandDto){
        return brandService.register(brandDto);
    }

    @GetMapping("/brands")
    Iterable<BrandDto> all() {
        return brandService.getAll();
    }

    @PostMapping("/brands/register")
    BrandDto newBrand(@RequestBody BrandDto brandDto) {  return brandService.register(brandDto); }

    @GetMapping("/brands/{id}")
    Optional<BrandDto> oneBrand(@PathVariable Integer id) {
        return brandService.getById(id);
    }

    @DeleteMapping("/brands/{id}")
    void deleteBrands(@PathVariable Integer id) {
        brandService.deleteById(id);
    }
}
