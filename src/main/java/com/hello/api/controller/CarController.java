package com.hello.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.api.dto.CarDTO;
import com.hello.api.model.Car;
import com.hello.api.repository.CarRepository;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarRepository repository;

    @GetMapping
    public List<Car> getAll(){
      return repository.findAll();
    }

    @PostMapping
    public void create(@RequestBody CarDTO req){

        repository.save(new Car(req) );
    }
}
