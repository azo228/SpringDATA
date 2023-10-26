package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.OfferDto;
import com.example.springdatabasicdemo.dtos.UserDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OfferService<UUID> {
    OfferDto createNewOffer(OfferDto offer);

    Optional<List<OfferDto>> getOffersLessThanPrice(BigDecimal price);

    void updateOfferDescription(String description, UUID id);

    void deleteOfferById(UUID id);

    Boolean deleteOffersBySeller(UserDto seller);
}
