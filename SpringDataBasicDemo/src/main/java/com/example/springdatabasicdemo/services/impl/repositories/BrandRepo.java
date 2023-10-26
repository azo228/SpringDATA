package com.example.springdatabasicdemo.services.impl.repositories;

import com.example.springdatabasicdemo.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends JpaRepository<Brand,Integer> {
}
