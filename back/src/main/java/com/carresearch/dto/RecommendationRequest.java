package com.carresearch.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommendationRequest {

    @NotNull
    private Double maxBudget;

    private String fuelType;
    private String bodyType;
    private String priority;
}
