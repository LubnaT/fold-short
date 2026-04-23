# Car Research Platform Backend

Minimal Spring Boot backend for a car research take-home assignment.

## Package structure

```text
com.carresearch
├── config
├── controller
├── dto
├── entity
├── repository
└── service
```

## Prerequisites

- Java 17
- Maven 3.9+
- MySQL 8+

## MySQL setup

Create the database before running the app:

```sql
CREATE DATABASE car_research_db;
```

Update credentials in `src/main/resources/application.properties` if your local MySQL username or password is different from `root` / `root`.

## Run the app

```bash
mvn spring-boot:run
```

The application starts on `http://localhost:8080`.

## API endpoints

### Get all cars

```http
GET /api/cars
```

### Get recommendations

```http
POST /api/recommend
Content-Type: application/json

{
  "maxBudget": 1200000,
  "fuelType": "Petrol",
  "bodyType": "SUV",
  "priority": "safety"
}
```

### Save shortlist

```http
POST /api/shortlist
Content-Type: application/json

{
  "carIds": [1, 6, 8]
}
```

### Get shortlist

```http
GET /api/shortlist
```
