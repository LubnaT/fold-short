DROP TABLE IF EXISTS shortlisted_cars;
DROP TABLE IF EXISTS cars;

CREATE TABLE cars (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    make VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    variant_name VARCHAR(150) NOT NULL,
    price DOUBLE NOT NULL,
    fuel_type VARCHAR(50) NOT NULL,
    body_type VARCHAR(50) NOT NULL,
    mileage DOUBLE NOT NULL,
    safety_rating DOUBLE NOT NULL,
    transmission VARCHAR(50) NOT NULL,
    seating_capacity INT NOT NULL,
    user_rating DOUBLE NOT NULL
);

CREATE TABLE shortlisted_cars (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    car_id BIGINT NOT NULL,
    CONSTRAINT fk_shortlisted_car FOREIGN KEY (car_id) REFERENCES cars(id)
);
