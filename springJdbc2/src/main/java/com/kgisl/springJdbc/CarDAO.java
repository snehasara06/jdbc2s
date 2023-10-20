package com.kgisl.springJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CarDAO {
    {
        System.out.println("Car DAO");
    }

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Car c) {
        String sql = "insert into morrisgarage(name,type,fuel,price,seater) values('" + c.getName() + "','"
                + c.getType() + "',"
                + c.getFuel() + "'," + c.getPrice() + "'," + c.getSeater() + ")";
        return template.update(sql);
    }

    public int update(Car c) {
        String sql = "update morrisgarage set name='" + c.getName() + "', type='" + c.getType() + "',fuel="
                + c.getFuel() + "',price=" + c.getPrice() + "',seater=" + c.getSeater()
                + " where id=" + c.getId() + "";
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "delete from morrisgarage where id =" + id + " ";
        return template.update(sql);
    }

    public Car getCarById(int id) {
        String sql = "select * from morrisgarage where id=?";
        // return template.queryForObject(sql, new Object[] { id }, new
        // BeanPropertyRowMapper<Car>(Car.class));
        // return template.queryForObject(sql,
        //         BeanPropertyRowMapper.newInstance(Car.class), id);
        return template.queryForObject(sql, new BeanPropertyRowMapper<Car>(Car.class),new Object[]{id});
    }

    public List<Car> getCars() {
        return template.query("select * from morrisgarage", new RowMapper<Car>() {
            public Car mapRow(ResultSet rs, int row) throws SQLException {
                Car c = new Car();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setType(rs.getString(3));
                c.setFuel(rs.getString(4));
                c.setPrice(rs.getString(5));
                c.setSeater(rs.getInt(6));
                return c;
            }
        });
    }
}
