package com.kgisl.springJdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfig {
    @Autowired
    DataSource datasSource;

    @Bean
    public JdbcTemplate jdbc(DataSource dataSrc){
        return new JdbcTemplate(dataSrc);
    }
    @Bean
    public CarDAO carDAO(JdbcTemplate jdbcTemp){
        CarDAO carDao=new CarDAO();
        carDao.setTemplate(jdbcTemp);
        return carDao;
    }
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
