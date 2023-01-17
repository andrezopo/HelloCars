package com.hello.api.hello.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.api.hello.dtos.CarDTO;

@RestController
@RequestMapping("/api/cars")
public class Car {
    @PostMapping
    public void create(@RequestBody CarDTO req){
        System.out.println("Modelo do carro: " + req.modelo());
        System.out.println("Marca: " + req.fabricante());
        System.out.println("Preço na concessionária: " + req.valor());
        System.out.println("Ano do modelo: " + req.anoModelo());
        System.out.println("Data de fabricação: " + req.dataFabricacao());
    }
}
