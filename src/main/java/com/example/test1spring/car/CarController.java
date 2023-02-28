package com.example.test1spring.car;

import com.example.test1spring.car.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService carService;

    @GetMapping("/id")
    public Car getCarById(@PathVariable int id) {
        return carService.getCarById(id);
    }


    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @PutMapping("/id")
    public Car updateCar(@PathVariable int id, @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    @DeleteMapping("/id")
    public void deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
    }
}

