package com.example.test1spring.car;

import com.example.test1spring.car.model.Car;
import com.example.test1spring.car.model.CarDto;
import com.example.test1spring.common.FuelType;
import com.example.test1spring.garage.GarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final GarageService garageService;


    @GetMapping
    public String getCars(Model model) {
        model.addAttribute("cars", carService.getCars());
        return "car/list";
    }

    @GetMapping("/create")
    public String getCarCreateForm(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("garages", garageService.findAll());
        return "car/form";
    }

    @PostMapping("/create")
    public String createCar(Car car, @RequestParam("garage") int garageId) {
        garageService.findGarageById(garageId);
        carService.createCar(car, garageId);
        return "redirect:/cars";
    }

    @GetMapping("/{id}")
    public String getCarById(@PathVariable Integer id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "car/details";
    }

    @GetMapping(params = "fuelType")
    public List<Car> getCarsByFuelType(@RequestParam FuelType fuelType) {
        return carService.getCarsByFuelType(fuelType);
    }

    @DeleteMapping("/{id}")
    public String deleteCarById(@PathVariable Integer id) {
        carService.deleteCarById(id);
        return "redirect:/cars";
    }
}

