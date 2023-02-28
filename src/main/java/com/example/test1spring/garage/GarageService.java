package com.example.test1spring.garage;

import com.example.test1spring.car.CarRepository;
import com.example.test1spring.garage.model.Garage;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GarageService {
    private final GarageRepository garageRepository;

    private final CarRepository carRepository;

    public Garage getGarageById(int id) {
        return garageRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Garage not found"));
    }

    public List<Garage> getAllGarages(Garage garage) {
        return garageRepository.findAll();
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
    public List<Garage> findAll() {
        return garageRepository.findAll();
    }

    public void save(Garage garage) {
        garageRepository.save(garage);
    }
}