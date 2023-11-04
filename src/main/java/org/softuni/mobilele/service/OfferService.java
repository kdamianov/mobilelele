package org.softuni.mobilele.service;


import java.util.Optional;
import java.util.UUID;
import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.dto.OfferDetailsDTO;
import org.softuni.mobilele.model.dto.OfferSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfferService {

  UUID createOffer(CreateOfferDTO createOfferDTO);

  Page<OfferSummaryDTO> getAllOffers(Pageable pageable);

  Optional<OfferDetailsDTO> getOfferDetails(UUID offerUUID);

  void deleteOffer(UUID offerUUID);
}
