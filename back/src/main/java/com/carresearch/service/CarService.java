package com.carresearch.service;

import com.carresearch.dto.CarResponse;
import com.carresearch.entity.Car;
import com.carresearch.repository.CarRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarResponse> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(car -> toCarResponse(car, null))
                .toList();
    }

    public CarResponse toCarResponse(Car car, String recommendationReason) {
        return CarResponse.builder()
                .id(car.getId())
                .make(car.getMake())
                .model(car.getModel())
                .variantName(car.getVariantName())
                .price(car.getPrice())
                .fuelType(car.getFuelType())
                .bodyType(car.getBodyType())
                .mileage(car.getMileage())
                .safetyRating(car.getSafetyRating())
                .transmission(car.getTransmission())
                .seatingCapacity(car.getSeatingCapacity())
                .userRating(car.getUserRating())
                .recommendationReason(recommendationReason)
                .build();
    }
}
