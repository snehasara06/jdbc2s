package com.kgisl.springJdbc.repository;

import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kgisl.springJdbc.Car;

public class CarRepository implements Repository {

    static JdbcTemplate jdbcTemp;

    @Override
    public int addCar(Car c) {
        return jdbcTemp.update("INSERT INTO morrisgarage (id,name,type,fuel,price,seater) VALUES (?,?,?,?,?,?)");
    }   
    


    @Override
    public int updateCar(Car c) {
        return jdbcTemp.update("UPDATE morrisgarage SET name=?, type=?,fuel=?,price=?,seater=? WHERE id=?",
        new Object[]{
            c.getName(),c.getType(),c.getFuel(),c.getPrice(),c.getSeater(),c.getId()

        });
    }

    // new Object[] { tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished(), tutorial.getId() });

    @Override
    public Car findById(int id) {
        try {
            // queryForObject() is used to fetch single row from the database.
            Car c = jdbcTemp.queryForObject("SELECT FROM morrisgarage WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Car.class), id);
            return c;
        } 
        catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemp.update("DELETE FROM morrisgarage WHERE id=?", id);
    }

    @Override
    public List<Car> findAll() {

        return jdbcTemp.query("SELECT * from morrisgarage",
                BeanPropertyRowMapper.newInstance(Car.class));

        // BeanPropertyRowMapper-converts a row into a new instance of the specified
        // mapped target class.
    }

    @Override
    public List<Car> findByName(String name) {

        return jdbcTemp.query("SELECT * from morrisgarage WHERE name=?",
                BeanPropertyRowMapper.newInstance(Car.class), name);
    }

    @Override
    public List<Car> findByType(String type) {
        String q = "SELECT * from morrisgarage WHERE price ILIKE '%" + type + "%'";
        // allow pattern matching within character-based column data.
        // LIKE is case-sensitive, ILIKE is case-insensitive.
        return jdbcTemp.query(q, BeanPropertyRowMapper.newInstance(Car.class));
    }

}
