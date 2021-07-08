package com.puc.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
		"com.puc.car.model.entities"
	})
@EnableJpaRepositories(basePackages = {
		"com.puc.car.model.repositories"
	})
public class CarApplication {
	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

}
