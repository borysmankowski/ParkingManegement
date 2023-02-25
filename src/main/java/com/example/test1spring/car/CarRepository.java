package com.example.test1spring.car;

import com.example.test1spring.car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Integer, Car> {
}
