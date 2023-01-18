package com.hello.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.api.model.Car;



public interface CarRepository extends JpaRepository<Car,Long> {
    
}
