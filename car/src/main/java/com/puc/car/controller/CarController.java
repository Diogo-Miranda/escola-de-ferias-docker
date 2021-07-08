package com.puc.car.controller;

import com.puc.car.model.entities.Car;
import com.puc.car.request.CarRequest;
import com.puc.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    private final CarService service;

    @Autowired
    CarController(CarService service) {
       this.service = service;
    }

    @GetMapping("/cars")
    public List<Car> getAll() {
        return service.getAll();
    }

    @PostMapping("/car")
    public Car add(
            @RequestBody CarRequest carRequest
            ) {
        return service.add(carRequest);
    }

    @GetMapping("/car/{id}")
    @ResponseBody
    public Optional<Car> get(
            @PathVariable("id") Integer Id
    ) {
        Optional<Car> car = service.get(Id);
        return car;
    }
}
