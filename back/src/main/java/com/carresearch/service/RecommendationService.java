package com.carresearch.service;

import com.carresearch.dto.CarResponse;
import com.carresearch.dto.RecommendationRequest;
import com.carresearch.entity.Car;
import com.carresearch.repository.CarRepository;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    private final CarRepository carRepository;
    private final CarService carService;

    public RecommendationService(CarRepository carRepository, CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    public List<CarResponse> recommendCars(RecommendationRequest request) {
        return carRepository.findByPriceLessThanEqual(request.getMaxBudget())
                .stream()
                .filter(car -> matchesOptional(car.getFuelType(), request.getFuelType()))
                .filter(car -> matchesOptional(car.getBodyType(), request.getBodyType()))
                .map(car -> new ScoredCar(car, calculateScore(car, request), buildReason(car, request)))
                .sorted(Comparator.comparingDouble(ScoredCar::score).reversed())
                .limit(5)
                .map(scoredCar -> carService.toCarResponse(scoredCar.car(), scoredCar.reason()))
                .toList();
    }

    private boolean matchesOptional(String actualValue, String requestedValue) {
        return requestedValue == null
                || requestedValue.isBlank()
                || actualValue.equalsIgnoreCase(requestedValue);
    }

    private double calculateScore(Car car, RecommendationRequest request) {
        String priority = request.getPriority() == null ? "value" : request.getPriority().trim().toLowerCase();
        double score = 0.0;

        if (request.getFuelType() != null && !request.getFuelType().isBlank()
                && car.getFuelType().equalsIgnoreCase(request.getFuelType())) {
            score += 15;
        }

        if (request.getBodyType() != null && !request.getBodyType().isBlank()
                && car.getBodyType().equalsIgnoreCase(request.getBodyType())) {
            score += 15;
        }

        switch (priority) {
            case "safety" -> score += car.getSafetyRating() * 20 + car.getUserRating() * 5;
            case "mileage" -> score += car.getMileage() * 3 + car.getUserRating() * 5;
            case "value" -> score += ((request.getMaxBudget() - car.getPrice()) / 100000.0) * 8 + car.getUserRating() * 10;
            default -> score += car.getUserRating() * 10;
        }

        return score;
    }

    private String buildReason(Car car, RecommendationRequest request) {
        String priority = request.getPriority() == null ? "value" : request.getPriority().trim().toLowerCase();
        return switch (priority) {
            case "safety" -> "Strong safety rating and solid owner feedback within your budget.";
            case "mileage" -> "High mileage efficiency makes this a practical running-cost pick.";
            case "value" -> "Offers a good balance of price and user rating for the budget.";
            default -> "Matches your budget and preference filters well.";
        };
    }

    private record ScoredCar(Car car, double score, String reason) {
    }
}
