package com.example.test1spring.garage;

import com.example.test1spring.garage.model.Garage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/garages")
public class GarageController {
    private GarageService garageService;

    @GetMapping("/{id}")
    public Garage getGarageById(@PathVariable int id) {
        return garageService.getGarageById(id);
    }
    @GetMapping("/all")
    public List<Garage> getAllGarages(Garage garage) {
        return garageService.getAllGarages(garage);
    }

    @PostMapping
    public Garage addGarage(@RequestBody Garage garage) {
        return garageService.addGarage(garage);
    }

    @PutMapping("/{id}")
    public Garage updateGarage(@PathVariable int id, @RequestBody Garage garage) {
        return garageService.updateGarage(id, garage);
    }

    @DeleteMapping("/{id}")
    public void deleteGarage(@PathVariable int id) {
        garageService.deleteGarage(id);
    }

    @PostMapping("/{garageId}/cars/{carId}")
    public void addCarToGarage(@PathVariable int garageId, @PathVariable int carId) {
        garageService.addCarToGarage(garageId, carId);
    }

    @DeleteMapping("/{garageId}/cars/{carId}")
    public void removeCarFromGarage(@PathVariable int garageId, @PathVariable int carId) {
        garageService.removeCarFromGarage(garageId, carId);
    }
}
