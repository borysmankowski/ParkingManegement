package com.example.test1spring.garage;

import com.example.test1spring.car.CarRepository;
import com.example.test1spring.car.model.Car;
import com.example.test1spring.common.FuelType;
import com.example.test1spring.garage.model.Garage;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GarageService {
    private GarageRepository garageRepository;

    private CarRepository carRepository;

    public Garage getGarageById(int id) {
        return garageRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Garage not found"));
    }

    public Garage addGarage(Garage garage) {
        return garageRepository.save(garage);
    }

    public Garage updateGarage(int id, Garage garage) {
        Garage existingGarage = getGarageById(id);
        existingGarage.setAddress(garage.getAddress());
        existingGarage.setCapacity(garage.getCapacity());
        existingGarage.setAcceptsLpg(garage.isAcceptsLpg());
        return garageRepository.save(existingGarage);
    }

    public void deleteGarage(int id) {
        garageRepository.deleteById(id);
    }

    public void addCarToGarage(int garageId, int carId) {
        Garage garage = getGarageById(garageId);
        Car car = carRepository.findById(carId).orElseThrow(() -> new EntityNotFoundException("Car not found"));

        if (!garage.isAcceptsLpg() && car.getFuelType() == FuelType.LPG) {
            throw new IllegalArgumentException("Garage doesn't accept LPG cars");
        }

        if (garage.getCars().size() >= garage.getCapacity()) {
            throw new IllegalStateException("Garage is full");
        }

        garage.getCars().add(car);
        car.getGarages().add(garage);
        garageRepository.save(garage);
        carRepository.save(car);
    }

    public void removeCarFromGarage(int garageId, int carId) {
        Garage garage = getGarageById(garageId);
        Car car = carRepository.findById(carId).orElseThrow(() -> new EntityNotFoundException("Car not found"));

        if (!garage.getCars().contains(car)) {
            throw new IllegalArgumentException("Car is not in the garage");
        }

        garage.getCars().remove(car);
        car.getGarages().remove(garage);
        garageRepository.save(garage);
        carRepository.save(car);
    }
}