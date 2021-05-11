package com.sunner.sbdatabases.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://remotemysql.com:3306/Lv8oIFJkzf")
                .username("Lv8oIFJkzf")
                .password("zg5wTpCRGM")
                .driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }
    //@EventListener(ApplicationReadyEvent.class)
    public void init(){
        String sql = "CREATE TABLE client(id int, name varchar(15), surename varchar(30), age int,  PRIMARY KEY (id))";
        getJdbcTemplate().update(sql);
    }


}
