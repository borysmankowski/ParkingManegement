package com.example.test1spring.garage.model;

import com.example.test1spring.car.model.Car;
import com.example.test1spring.common.FuelType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@SQLDelete(sql = "UPDATE garage SET active = '0' WHERE id = ?")
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    private int capacity;

    private boolean acceptsLpg;

    boolean active;

    @OneToMany(mappedBy = "garage")
    private Set<Car> cars;

//    public boolean canAddCar(Car car) {
//        if (cars.size() >= capacity) {
//            throw new RuntimeException("Garage cannot accept this car as its using LPG");
//        }
//        if (car.getFuelType() == FuelType.LPG && !acceptsLpg) {
//            return false;
//        }
//        cars.add(car);
//        car.setGarage(this);
//        return true;
//    }

//    public void addCar(Car car) {
//        if (!canAddCar(car)) {
//            throw new RuntimeException("Garage is full or cannot accept this car");
//        }
//        cars.add(car);
//        car.setGarage(this);
//    }

//    public void removeCar(Car car) {
//        cars.remove(car);
//        car.setGarage(null);
//    }

}
