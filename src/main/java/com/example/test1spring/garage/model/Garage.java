package com.example.test1spring.garage.model;

import com.example.test1spring.car.model.Car;
import com.example.test1spring.common.FuelType;
import com.example.test1spring.garage.GarageRepository;
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
            throw new RuntimeException("Garage cannot accept this car as its using LPG");
        }
        if (car.getFuelType() == FuelType.LPG && !acceptsLpg) {
            return false;
        }
        cars.add(car);
        car.setGarage(this);
        return true;
    }

    public void addCar(Car car) {
        if (!canAddCar(car)) {
            throw new RuntimeException("Garage is full or cannot accept this car");
        }
        cars.add(car);
        car.setGarage(this);
    }

    public void removeCar(Car car) {
        cars.remove(car);
        car.setGarage(null);
    }

}
