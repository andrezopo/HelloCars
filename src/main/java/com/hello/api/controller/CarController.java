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

import jakarta.validation.Valid;

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
    public void create(@RequestBody @Valid CarDTO req){

        repository.save(new Car(req) );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
      if (repository.findById(id).isEmpty()){
        return;
      }

      repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req){
     
      repository.findById(id).map(car -> {
        car.setAnoModelo(req.anoModelo());
        car.setDataFabricacao(req.dataFabricacao());
        car.setFabricante(req.fabricante());
        car.setModelo(req.modelo());
        car.setValor(req.valor());

        return repository.save(car);
      });

    }
}
