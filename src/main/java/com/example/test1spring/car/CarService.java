package com.example.test1spring.car;

import com.example.test1spring.car.model.Car;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private CarRepository carRepository;

    public Car getCarById(int id) {
        return carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Car not found"));
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(int id, Car car) {
        Car existingCar = getCarById(id);
        existingCar.setBrand(car.getBrand());
        existingCar.setModel(car.getModel());
        existingCar.setFuelType(car.getFuelType());
        return carRepository.save(existingCar);
    }

    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}