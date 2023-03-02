package com.example.test1spring.garage;

import com.example.test1spring.garage.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GarageRepository extends JpaRepository<Garage,Integer>{
    List<Garage> findAllByActiveTrue();

}
