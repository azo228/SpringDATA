package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.BrandDto;
import com.example.springdatabasicdemo.dtos.ModelDto;
import com.example.springdatabasicdemo.enums.Category;

import java.util.List;
import java.util.Optional;

public interface ModelService<UUID> {

    ModelDto createNewModel(ModelDto model);

    Optional<List<ModelDto>> getModelsOfUniqueBrand(BrandDto brand);

    Optional<ModelDto> getModelWithUniqueName(String modelName);

    Optional<List<ModelDto>> getModelsOfCategory(Category category);

    void addModelImage(String imageUrl, UUID id);

    void deleteModelById(UUID id);
}
