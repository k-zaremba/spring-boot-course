package com.sunner.springbootapis.database.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean
    public DataSource getDataSrc(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        return dataSourceBuilder.url("jdbc:mysql://remotemysql.com:3306/KKSfahPMyn")
                .username("KKSfahPMyn")
                .password("dSo9odpK69")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Bean
    public JdbcTemplate getJdbc(){
        return new JdbcTemplate(getDataSrc());
    }

    //@EventListener(ApplicationReadyEvent.class)
    public void init(){
        String sql = "CREATE TABLE info(city varchar(20), min_temp float(6), max_temp float(6), date date)";
        getJdbc().update(sql);
    }

}
