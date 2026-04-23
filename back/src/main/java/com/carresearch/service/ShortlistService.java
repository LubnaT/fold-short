package com.carresearch.service;

import com.carresearch.dto.CarResponse;
import com.carresearch.dto.ShortlistRequest;
import com.carresearch.entity.Car;
import com.carresearch.entity.ShortlistedCar;
import com.carresearch.repository.CarRepository;
import com.carresearch.repository.ShortlistedCarRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ShortlistService {

    private final ShortlistedCarRepository shortlistedCarRepository;
    private final CarRepository carRepository;
    private final CarService carService;

    public ShortlistService(ShortlistedCarRepository shortlistedCarRepository,
                            CarRepository carRepository,
                            CarService carService) {
        this.shortlistedCarRepository = shortlistedCarRepository;
        this.carRepository = carRepository;
        this.carService = carService;
    }

    public List<CarResponse> saveShortlist(ShortlistRequest request) {
        shortlistedCarRepository.deleteAll();

        List<ShortlistedCar> shortlist = request.getCarIds()
                .stream()
                .map(this::findCar)
                .map(car -> new ShortlistedCar(null, car))
                .toList();

        shortlistedCarRepository.saveAll(shortlist);
        return getShortlist();
    }

    public List<CarResponse> getShortlist() {
        return shortlistedCarRepository.findAll()
                .stream()
                .map(ShortlistedCar::getCar)
                .map(car -> carService.toCarResponse(car, null))
                .toList();
    }

    private Car findCar(Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException("Car not found for id: " + carId));
    }
}
