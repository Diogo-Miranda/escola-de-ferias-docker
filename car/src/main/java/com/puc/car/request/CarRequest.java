package com.puc.car.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarRequest {
    private String marca;
    private String modelo;
    private String placa;
    private Long km;
    private String cor;
    private String ano;
}
