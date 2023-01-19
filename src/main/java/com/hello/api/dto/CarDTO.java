package com.hello.api.dto;


import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CarDTO(

@NotBlank
String modelo, 

@NotBlank
String fabricante, 

@NotNull
@Past
Date dataFabricacao, 

@NotNull
@Min(0)
int valor, 

@NotNull
@Min(1900)
int anoModelo) {
    
}

// {
// 	"modelo": "Fiat Argo 1.3",
// 	"fabricante": "Fiat",
// 	"dataFabricacao": "10/02/2006",
// 	"valor": 10.000,
// 	"anoModelo": 2023,
// }