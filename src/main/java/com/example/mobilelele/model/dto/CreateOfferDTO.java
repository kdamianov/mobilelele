package com.example.mobilelele.model.dto;

import com.example.mobilelele.model.enums.Engine;
import com.example.mobilelele.model.enums.Transmission;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateOfferDTO(
        @NotEmpty  String description,
        Long modelId,
        Engine engine,
        Transmission transmission,
        String imageUrl,
        Integer mileage,
        Integer price,
        Integer year
) {
}
