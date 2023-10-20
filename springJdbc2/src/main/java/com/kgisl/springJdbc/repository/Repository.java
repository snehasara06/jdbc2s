package com.kgisl.springJdbc.repository;

import java.util.List;

import com.kgisl.springJdbc.Car;

public interface Repository {
    
    int addCar(Car c);
    int updateCar(Car c);
    Car findById(int id);
    int deleteById(int id);

    List<Car> findAll(); // to get all the cars
    List<Car> findByName(String name);
    List<Car> findByType(String type);

}
