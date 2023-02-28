package com.example.test1spring.car.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CarDto {

    private int id;

    private String make;

    private String model;
    public static CarDto fromEntity(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .make(car.getMake())
                .model(car.getModel())
                .build();
    }
}
