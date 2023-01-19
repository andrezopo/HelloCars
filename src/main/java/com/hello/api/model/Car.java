package com.hello.api.model;

import java.util.Date;

import com.hello.api.dto.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Car {

    public Car(CarDTO data){
        this.anoModelo = data.anoModelo();
        this.dataFabricacao = data.dataFabricacao();
        this.fabricante = data.fabricante();
        this.modelo = data.modelo();
        this.valor = data.valor();
    }

    public Car(){
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String modelo;

    @Column(length = 50, nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private Date dataFabricacao;

    @Column(nullable = false)
    private int valor;

    @Column(nullable = false)
    private int anoModelo;

}

// {
// 	"modelo": "Fiat Argo 1.3",
// 	"fabricante": "Fiat",
// 	"dataFabricacao": "10/02/2006",
// 	"valor": 10.000,
// 	"anoModelo": 2023,
// }
