package com.puc.car.model.entities;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String marca;
    private String modelo;
    private String placa;
    private Long km;
    private String cor;
    private String ano;

    public Car(String marca, String modelo, String placa, Long km, String cor, String ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.km = km;
        this.cor = cor;
        this.ano = ano;
    }
}
