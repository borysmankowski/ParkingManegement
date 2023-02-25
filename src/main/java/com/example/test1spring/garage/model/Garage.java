package com.example.test1spring.garage.model;

import com.example.test1spring.car.model.Car;
import com.example.test1spring.common.FuelType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    private int capacity;

    private boolean acceptsLpg;

    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();

    public boolean canAddCar(Car car) {
        if (cars.size() >= capacity) {
            return false;
        }
        if (car.getFuelType() == FuelType.LPG && !acceptsLpg) {
            return false;
        }
        return true;
    }
}
