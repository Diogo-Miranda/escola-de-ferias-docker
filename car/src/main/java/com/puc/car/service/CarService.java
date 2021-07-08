package com.puc.car.service;

import com.puc.car.model.entities.Car;
import com.puc.car.model.repositories.CarRepository;
import com.puc.car.request.CarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository repository;

    @Autowired
    CarService(CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> getAll() {
        return repository.findAll();
    }

    public Car add(CarRequest carRequest) {
        Car car = new Car(
                carRequest.getMarca(),
                carRequest.getModelo(),
                carRequest.getPlaca(),
                carRequest.getKm(),
                carRequest.getCor(),
                carRequest.getAno()
        );

        return repository.save(car);
    }

    public Optional<Car> get(Integer id) {
        Optional<Car> car = repository.findById(id);

        return car;
    }
}
