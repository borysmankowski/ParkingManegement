package com.example.test1spring.car.model;

import com.example.test1spring.common.FuelType;
import com.example.test1spring.garage.model.Garage;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;

    private String model;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @ManyToOne
    private Garage garage;

    public void setGarage(Garage garage) {
        this.garage = garage;
        garage.getCars().add(this);
    }

    public List<Garage> getGarages() {
        return (List<Garage>) garage;
    }
}


