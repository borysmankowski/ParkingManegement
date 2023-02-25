package com.example.test1spring.car.model;

import com.example.test1spring.common.FuelType;
import jakarta.persistence.*;
import lombok.*;

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

}

