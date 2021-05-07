package com.sunner.springbootapis.api.controller;

import com.sunner.springbootapis.api.model.Car;
import com.sunner.springbootapis.api.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cars")
public class CarApi {


    CarServiceImpl carService;

    @Autowired
    public CarApi(CarServiceImpl carService) {
        this.carService = carService;
    }

    public CarServiceImpl getCarService() {
        return carService;
    }

    public void setCarService(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> carList = carService.getAllCars();

        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @GetMapping("/amount")
    public ResponseEntity<List<Car>> getAmountOfCars(@RequestHeader int amount) {
        List<Car> carList = carService.getAllCars();

        return new ResponseEntity<>(carList.subList(0, amount), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id) {
        Optional<Car> carOptional = carService.getCarById(id);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            return new ResponseEntity<>(car, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Car>> getCarsByColor(@PathVariable String color) {
        List<Car> carList = carService.getCarsByColor(color);
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car newCar) {
        if (carService.addCar(newCar))
            return new ResponseEntity(newCar, HttpStatus.CREATED);
        else
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity modCar(@RequestBody Car newCar) {
        Optional<Car> first = carService.getCarById(newCar.getId());

        if (first.isPresent()) {
            carService.getCarList().remove(first.get());
            carService.addCar(newCar);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> removeCarById(@PathVariable long id) {
        Optional<Car> first = carService.getCarById(id);

        if (first.isPresent()) {
            carService.getCarList().remove(first.get());
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
