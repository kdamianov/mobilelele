package com.example.mobilelele.model.dto;

import com.example.mobilelele.model.enums.Engine;
import com.example.mobilelele.model.enums.Transmission;

public record CreateOfferDTO(
        String description,
        Long modelId,
        Engine engine,
        Transmission transmission,
        String imageUrl,
        Integer mileage,
        Integer price,
        Integer year
) {
}
