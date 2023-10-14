package com.example.mobilelele.model.dto;

import com.example.mobilelele.model.enums.Engine;
import com.example.mobilelele.model.enums.Transmission;
import jakarta.validation.constraints.*;

import java.util.Objects;

public final class CreateOfferDTO {
    @NotEmpty
    @Size(min = 5, max = 512, message = "Description must be between 5 and 512 symbols!!!")
    private String description;
    @Positive
    @NotNull
    private Long modelId;
    @NotNull
    private Engine engine;
    @NotNull
    private Transmission transmission;
    @NotEmpty
    private String imageUrl;
    @Positive(message = "Mileage must be with a positive value!!!")
    @NotNull
    private Integer mileage;
    @Positive(message = "Price must be with a positive value!!!")
    @NotNull
    private Integer price;
    @NotNull
    @Min(value = 1930, message = "Year must be after 1930!!!")
    private Integer year;

    public CreateOfferDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}

