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


}
