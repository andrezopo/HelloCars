package com.hello.api.controller;

import java.util.List;

import org.aspectj.weaver.ast.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.api.dto.CarDTO;
import com.hello.api.model.Car;
import com.hello.api.repository.CarRepository;
import com.hello.api.service.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping
    public List<Car> getAll(){
      return service.findAll();
    }

    @PostMapping
    public void create(@RequestBody @Valid CarDTO req){

        service.save(req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
      service.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req){
     
      service.updateById(id, req);

    }
}
