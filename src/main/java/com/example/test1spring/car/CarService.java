package com.example.test1spring.car;

import com.example.test1spring.car.model.Car;
import com.example.test1spring.common.FuelType;
import com.example.test1spring.garage.GarageRepository;
import com.example.test1spring.garage.model.Garage;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CarService {
    private final CarRepository carRepository;

    private final GarageRepository garageRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public void save(Car car, int garageId) {
        Garage garage = garageRepository.findById(garageId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("Garage with id: {0} was not found ",garageId)));

        if (garage.getCapacity() >= garage.getCapacity()) {
            throw new RuntimeException("Garage cannot accept this car as its full");
        }
        if (car.getFuelType() == FuelType.LPG && !garage.isAcceptsLpg()) {
            throw new RuntimeException("Garage cannot accept this garage does not accept LGP");
        }

        car.setGarage(garage);
        car.setActive(true);
        carRepository.save(car);
    }
    public void deleteById(int id) {
        carRepository.deleteById(id);
    }

    public List<Car> findAllByGarageId(int garageId) {
        return carRepository.findAllByGarageId(garageId);
    }
}