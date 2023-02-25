package com.example.test1spring.garage;

import com.example.test1spring.car.CarRepository;
import com.example.test1spring.car.model.Car;
import com.example.test1spring.garage.model.Garage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GarageController {

    @Autowired
    private GarageRepository garageRepository;

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Garage> garages = garageRepository.findAll();
        model.addAttribute("garages", garages);
        return "index";
    }

    @GetMapping("/garage/{garageId}")
    public String showGarage(@PathVariable int garageId, Model model) {
        Garage garage = garageRepository.findById(garageId).orElseThrow(() -> new IllegalArgumentException("Invalid garage ID"));
        model.addAttribute("garage", garage);
        model.addAttribute("car", new Car());
        return "garage";
    }

    @PostMapping("/garage/addCar")
    public synchronized String addCarToGarage(@RequestParam int garageId, @RequestParam int carId) {
        Garage garage = garageRepository.findById(garageId).orElseThrow(() -> new RuntimeException("Garage not found"));
        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));

        if (!garage.canAddCar(car)) {
            throw new RuntimeException("Garage is full or cannot accept this car");
        }

        if (!garage.canAcceptCarLpg(car)) {
            throw new RuntimeException("Garage does not accept LPG cars");
        }

        garage.addCar(car);
        garageRepository.save(garage);

        return "redirect:/garage/" + garageId;
    }

    @PostMapping("/garage/removeCar")
    public synchronized String removeCarFromGarage(@RequestParam int garageId, @RequestParam int carId) {
        Garage garage = garageRepository.findById(garageId).orElseThrow(() -> new RuntimeException("Garage not found"));
        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));

        garage.removeCar(car);
        garageRepository.save(garage);

        return "redirect:/garage/" + garageId;
    }
}
