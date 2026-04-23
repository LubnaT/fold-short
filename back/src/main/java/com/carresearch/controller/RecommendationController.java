package com.carresearch.controller;

import com.carresearch.dto.CarResponse;
import com.carresearch.dto.RecommendationRequest;
import com.carresearch.service.RecommendationService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommend")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping
    public List<CarResponse> recommendCars(@Valid @RequestBody RecommendationRequest request) {
        return recommendationService.recommendCars(request);
    }
}
