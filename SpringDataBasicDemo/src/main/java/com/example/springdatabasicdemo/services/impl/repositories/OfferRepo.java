package com.example.springdatabasicdemo.services.impl.repositories;

import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Integer> {
}
