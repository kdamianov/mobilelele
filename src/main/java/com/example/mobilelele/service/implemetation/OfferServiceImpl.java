package com.example.mobilelele.service.implemetation;

import com.example.mobilelele.model.dto.CreateOfferDTO;
import com.example.mobilelele.repository.OfferRepository;
import com.example.mobilelele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository){

        this.offerRepository = offerRepository;
    }
    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {

        throw new UnsupportedOperationException("Coming soon!");
    }
}
