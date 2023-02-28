package com.example.test1spring.garage;

import com.example.test1spring.garage.model.Garage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/garages")
public class GarageController {

    private final GarageService garageService;

    @GetMapping
    public String getGaragesList(Model model) {
        model.addAttribute("garages", garageService.findAll());
        return "garages/list";
    }

    @GetMapping("/create")
    public String getGarageCreateFrom(Model model) {
        model.addAttribute("garages", garageService.findAll());
        return "garages/form";
    }

  @PostMapping("/create")
    public String createGarage(Garage garage){
        garageService.save(garage);
        return "redirect:/garages";
  }
}
