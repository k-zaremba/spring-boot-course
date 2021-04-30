package com.sunner.spring_hateoas.controller;

import com.sunner.spring_hateoas.model.Car;
import com.sunner.spring_hateoas.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/cars", produces = {MediaType.APPLICATION_JSON_VALUE})
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
    public ResponseEntity<CollectionModel<Car>> getAllCars() {
        List<Car> carList = carService.getAllCars();

        for(Car car : carList){
            if(!car.hasLinks()) {
                car.add(linkTo(CarApi.class).slash(car.getId()).withSelfRel());
                car.add(linkTo(CarApi.class).slash("color/" + car.getColor()).withRel("all " + car.getColor().toLowerCase() + " cars"));
            }
        }
        Link link = linkTo(CarApi.class).withSelfRel();
        CollectionModel<Car> carCollectionModel = CollectionModel.of(carList, link);
        return new ResponseEntity<>(carCollectionModel, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Car>> getCarById(@PathVariable long id) {
        Optional<Car> carOptional = carService.getCarById(id);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            Link link = linkTo(CarApi.class).slash(id).withSelfRel();
            EntityModel<Car> carEntityModel = EntityModel.of(car, link, linkTo(CarApi.class).withRel("all cars"));
            return new ResponseEntity<>(carEntityModel, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<CollectionModel<Car>> getCarsByColor(@PathVariable String color) {
        List<Car> carList = carService.getCarsByColor(color);
        Link link = linkTo(CarApi.class).withRel("all cars");
        CollectionModel<Car> carCollectionModel = CollectionModel.of(carList, link);
        return new ResponseEntity<>(carCollectionModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addCar(@RequestBody Car newCar) {
        if (carService.getCarList().add(newCar))
            return new ResponseEntity(HttpStatus.CREATED);
        else
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity modCar(@RequestBody Car newCar) {
        Optional<Car> first = carService.getCarById(newCar.getId());

        if (first.isPresent()) {
            carService.getCarList().remove(first.get());
            carService.getCarList().add(newCar);
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
