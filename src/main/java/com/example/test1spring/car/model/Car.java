package com.example.test1spring.car.model;

import com.example.test1spring.common.FuelType;
import com.example.test1spring.garage.model.Garage;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@SQLDelete(sql = "UPDATE car SET active = '0' WHERE id = ?")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String make;

    private String model;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @ManyToOne
    private Garage garage;

    private boolean active;

    @OneToMany(mappedBy = "car")
    private Set<Car> carList;
}


