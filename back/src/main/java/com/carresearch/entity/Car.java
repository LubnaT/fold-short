package com.carresearch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(name = "variant_name", nullable = false)
    private String variantName;

    @Column(nullable = false)
    private Double price;

    @Column(name = "fuel_type", nullable = false)
    private String fuelType;

    @Column(name = "body_type", nullable = false)
    private String bodyType;

    @Column(nullable = false)
    private Double mileage;

    @Column(name = "safety_rating", nullable = false)
    private Double safetyRating;

    @Column(nullable = false)
    private String transmission;

    @Column(name = "seating_capacity", nullable = false)
    private Integer seatingCapacity;

    @Column(name = "user_rating", nullable = false)
    private Double userRating;
}
