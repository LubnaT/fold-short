package com.carresearch.repository;

import com.carresearch.entity.ShortlistedCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortlistedCarRepository extends JpaRepository<ShortlistedCar, Long> {

    void deleteAll();
}
