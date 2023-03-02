package com.example.test1spring.garage;

import com.example.test1spring.car.CarRepository;
import com.example.test1spring.garage.model.Garage;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GarageService {

    private final GarageRepository garageRepository;

    public List<Garage> findAll() {
        return garageRepository.findAllByActiveTrue();
    }

    public void save(Garage garage) {
        garage.setActive(true);
        garageRepository.save(garage);
    }

    public void deleteById(int id) {
        garageRepository.deleteById(id);
    }

    public Garage getGarageById(int id) {
        return garageRepository.getById(id);
    }

    public Garage findGarageById(int id) {
        return garageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Garage with id: {0} was not found", id)));
    }
}