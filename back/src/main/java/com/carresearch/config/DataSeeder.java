package com.carresearch.config;

import com.carresearch.entity.Car;
import com.carresearch.repository.CarRepository;
import java.util.List;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    ApplicationRunner seedCars(CarRepository carRepository) {
        return args -> {
            if (carRepository.count() > 0) {
                return;
            }

            carRepository.saveAll(List.of(
                    new Car(null, "Hyundai", "Creta", "SX 1.5 Petrol", 1180000.0, "Petrol", "SUV", 17.4, 4.0, "Manual", 5, 4.4),
                    new Car(null, "Hyundai", "Venue", "SX Turbo", 1080000.0, "Petrol", "SUV", 18.1, 4.0, "Manual", 5, 4.3),
                    new Car(null, "Kia", "Seltos", "HTK Plus", 1195000.0, "Petrol", "SUV", 17.0, 3.5, "Manual", 5, 4.2),
                    new Car(null, "Kia", "Sonet", "HTX Diesel", 1140000.0, "Diesel", "SUV", 24.1, 3.5, "Automatic", 5, 4.3),
                    new Car(null, "Maruti Suzuki", "Brezza", "ZXI", 1120000.0, "Petrol", "SUV", 19.8, 4.0, "Manual", 5, 4.4),
                    new Car(null, "Tata", "Nexon", "Creative Plus", 1200000.0, "Petrol", "SUV", 17.4, 5.0, "Manual", 5, 4.5),
                    new Car(null, "Tata", "Punch", "Accomplished", 890000.0, "Petrol", "SUV", 18.8, 5.0, "Manual", 5, 4.3),
                    new Car(null, "Mahindra", "XUV300", "W6 Turbo", 1165000.0, "Petrol", "SUV", 18.2, 5.0, "Manual", 5, 4.2),
                    new Car(null, "Mahindra", "Bolero Neo", "N10", 1095000.0, "Diesel", "SUV", 17.3, 4.0, "Manual", 7, 4.0),
                    new Car(null, "Honda", "City", "V CVT", 1190000.0, "Petrol", "Sedan", 18.4, 4.0, "Automatic", 5, 4.6),
                    new Car(null, "Honda", "Amaze", "VX CVT", 950000.0, "Petrol", "Sedan", 18.6, 4.0, "Automatic", 5, 4.4),
                    new Car(null, "Hyundai", "Verna", "SX IVT", 1240000.0, "Petrol", "Sedan", 19.6, 5.0, "Automatic", 5, 4.5),
                    new Car(null, "Volkswagen", "Virtus", "Highline", 1190000.0, "Petrol", "Sedan", 19.4, 5.0, "Manual", 5, 4.4),
                    new Car(null, "Skoda", "Slavia", "Ambition", 1160000.0, "Petrol", "Sedan", 19.5, 5.0, "Manual", 5, 4.4),
                    new Car(null, "Maruti Suzuki", "Baleno", "Alpha AMT", 940000.0, "Petrol", "Hatchback", 22.3, 4.0, "Automatic", 5, 4.3),
                    new Car(null, "Toyota", "Glanza", "V AMT", 960000.0, "Petrol", "Hatchback", 22.9, 4.0, "Automatic", 5, 4.4),
                    new Car(null, "Hyundai", "i20", "Asta IVT", 1030000.0, "Petrol", "Hatchback", 20.0, 3.0, "Automatic", 5, 4.2),
                    new Car(null, "Tata", "Altroz", "XZ DCA", 980000.0, "Petrol", "Hatchback", 18.5, 5.0, "Automatic", 5, 4.3),
                    new Car(null, "Maruti Suzuki", "Grand Vitara", "Sigma", 1170000.0, "Petrol", "SUV", 21.1, 4.0, "Manual", 5, 4.2),
                    new Car(null, "Toyota", "Urban Cruiser Hyryder", "E", 1198000.0, "Petrol", "SUV", 20.6, 4.0, "Manual", 5, 4.2)
            ));
        };
    }
}
