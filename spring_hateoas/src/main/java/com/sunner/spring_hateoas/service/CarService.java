package com.sunner.spring_hateoas.service;

import com.sunner.spring_hateoas.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getAllCars();

    Optional<Car> getCarById(long id);

    List<Car> getCarsByColor(String color);
}
