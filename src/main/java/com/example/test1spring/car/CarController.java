package com.example.test1spring.car;

import com.example.test1spring.car.model.Car;
import com.example.test1spring.car.model.CarDto;
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
    public String getCarList(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "car/list";
    }

    @GetMapping("/create")
    public String getCarCreateForm(Model model) {
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("garages", garageService.findAll());
        return "car/form";
    }

    @PostMapping("/create")
    public String createCar(Car car, @RequestParam("garageId") int garageId) {
        carService.save(car, garageId);
        return "redirect:/cars";
    }

    @GetMapping(params = "garage")
    @ResponseBody
    public List<CarDto> findAllbyGarage(@RequestParam("garage") int garageId) {
        return carService.findAllByGarageId(garageId).stream()
                .map(CarDto::fromEntity)
                .toList();
    }
}

