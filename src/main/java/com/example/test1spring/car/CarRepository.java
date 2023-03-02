package com.example.test1spring.car;

import com.example.test1spring.car.model.Car;
import com.example.test1spring.common.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> findByFuelType(FuelType fuelType);
}
