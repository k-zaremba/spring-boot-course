package com.sunner.springbootapis.api.service;

import com.sunner.springbootapis.api.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{
    private List<Car> carList;

    public CarServiceImpl() {
        this.carList = new ArrayList<>();
        carList.add(new Car(1L, "Nissan", "Blue"));
        carList.add(new Car(2L, "Skoda", "Silver"));
        carList.add(new Car(3L, "Honda", "Black"));
        carList.add(new Car(4L, "Mercedes", "Red"));
        carList.add(new Car(5L, "Volvo", "Silver"));
        carList.add(new Car(6L, "Ferrari", "Red"));
        carList.add(new Car(7L, "Audi", "Black"));

    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public List<Car> getAllCars() {
        return carList;
    }

    @Override
    public Optional<Car> getCarById(long id) {
        return carList.stream().filter(car -> car.getId() == id).findFirst();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return carList.stream().filter(car -> car.getColor().equals(color)).collect(Collectors.toList());
    }

    @Override
    public boolean addCar(Car car){
        return this.carList.add(car);
    }

}
