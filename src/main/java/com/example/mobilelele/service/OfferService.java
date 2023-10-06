package com.example.mobilelele.service;

import com.example.mobilelele.model.dto.CreateOfferDTO;

import java.util.UUID;

public interface OfferService {

    UUID createOffer(CreateOfferDTO createOfferDTO);
}
