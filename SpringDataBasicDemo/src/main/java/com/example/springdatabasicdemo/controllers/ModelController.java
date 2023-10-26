package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.ModelDto;
import com.example.springdatabasicdemo.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ModelController {
    @Autowired
    CrudService<ModelDto,Integer> modelService;

    @PostMapping("/models/update")
    ModelDto update(@RequestBody ModelDto modelDto){
        return modelService.register(modelDto);
    }

    @GetMapping("/models")
    Iterable<ModelDto> all() {
        return modelService.getAll();
    }

    @PostMapping("/models/register")
    ModelDto newModel(@RequestBody ModelDto brandDto) {  return modelService.register(brandDto); }

    @GetMapping("/models/{id}")
    Optional<ModelDto> oneModel(@PathVariable Integer id) {
        return modelService.getById(id);
    }

    @DeleteMapping("/models/{id}")
    void deleteModels(@PathVariable Integer id) {
        modelService.deleteById(id);
    }
}
