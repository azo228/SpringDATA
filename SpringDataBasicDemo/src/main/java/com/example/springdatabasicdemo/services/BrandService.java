package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.BrandDto;
import com.example.springdatabasicdemo.dtos.ModelDto;
import com.example.springdatabasicdemo.models.Brand;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface BrandService<UUID> {

    BrandDto addBrand(BrandDto brand);

    List<BrandDto> getAllBrands();

    void deleteBrandByName(String brandName);

    void deleteBrandById(UUID id);

}

