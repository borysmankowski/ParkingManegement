package com.example.test1spring.garage.model;

import com.example.test1spring.car.model.Car;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class GarageDto {

    private int id;
    private String address;
    private int capacity;
    private Set<Car> cars;

    private static GarageDto fromEntity(Garage garage) {
        return GarageDto.builder()
                .id(garage.getId())
                .address(garage.getAddress())
                .capacity(garage.getCapacity())
                .cars(garage.getCars())
                .build();
    }
}
