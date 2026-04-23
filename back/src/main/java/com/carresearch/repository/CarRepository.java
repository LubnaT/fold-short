package com.carresearch.repository;

import com.carresearch.entity.Car;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByPriceLessThanEqual(Double price);
}
