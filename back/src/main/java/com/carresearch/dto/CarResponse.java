package com.carresearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarResponse {

    private Long id;
    private String make;
    private String model;
    private String variantName;
    private Double price;
    private String fuelType;
    private String bodyType;
    private Double mileage;
    private Double safetyRating;
    private String transmission;
    private Integer seatingCapacity;
    private Double userRating;
    private String recommendationReason;
}
