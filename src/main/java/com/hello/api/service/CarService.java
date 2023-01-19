package com.hello.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.api.dto.CarDTO;
import com.hello.api.model.Car;
import com.hello.api.repository.CarRepository;

@Service
public class CarService {
    
    @Autowired
    private CarRepository repository;

    public List<Car> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id){
        if (repository.findById(id).isEmpty()){
            return;
          }
    
          repository.deleteById(id);
    }

    public void updateById(Long id, CarDTO req) {
        repository.findById(id).map(car -> {
            car.setAnoModelo(req.anoModelo());
            car.setDataFabricacao(req.dataFabricacao());
            car.setFabricante(req.fabricante());
            car.setModelo(req.modelo());
            car.setValor(req.valor());
    
            return repository.save(car);
          });
    }

    public void save(CarDTO req) {
        repository.save(new Car(req) );
    }
}
