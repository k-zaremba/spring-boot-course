package com.sunner.springbootapis.database;

import com.sunner.springbootapis.client.homework.model.WeatherInfo;

import java.util.List;

public interface InfoDao {
    void create(WeatherInfo weatherInfo);
    List<Info> readAll();
    void delete(String city);
}
