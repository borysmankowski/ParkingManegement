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
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private int capacity;
    private boolean acceptsLpg;

    @OneToMany(mappedBy = "garage")
    private Set<Car> cars;
    private boolean active;

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                ", acceptsLpg=" + acceptsLpg +
                ", cars=" + cars +
                ", active=" + active +
                '}';
    }

}
