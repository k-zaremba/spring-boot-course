package com.sunner.springbootapis.database;

import com.sunner.springbootapis.client.homework.model.WeatherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class InfoDaoImpl implements InfoDao{

    JdbcTemplate jdbcTemplate;

    @Autowired
    public InfoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
    {city.getTitle()}"></p></td>
{#numbers.formatDecimal(city.getTodayWeather().getMinTemp(), 0, 2)}"></p></
{#numbers.formatDecimal(city.getTodayWeather().getMaxTemp(), 0, 2)}"></p></
{city.getTodayWeather().getApplicableDate()}"></p></td>
th="30px" th:src="${city.getImageUrl()}"></image></td>
     */
    @Override
    public void create(WeatherInfo weatherInfo) {
        String sql = "INSERT INTO info VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, weatherInfo.getTitle(),  Math.round(weatherInfo.getTodayWeather().getMinTemp() * 100.0) / 100.0,
                Math.round(weatherInfo.getTodayWeather().getMaxTemp() * 100.0 / 100.0), weatherInfo.getTodayWeather().getApplicableDate());
    }

    @Override
    public List<Info> readAll() {
        List<Info> infoList = new ArrayList<>();
        String sql = "SELECT * FROM info";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        mapList.forEach(mapObject -> infoList.add(
                new Info(String.valueOf(mapObject.get("city")),
                        Double.parseDouble(String.valueOf(mapObject.get("min_temp"))),
                        Double.parseDouble(String.valueOf(mapObject.get("max_temp"))),
                        (Date) mapObject.get("date"))));
        return infoList;
    }

    @Override
    public void delete(String city) {
        String sql = "DELETE FROM info WHERE info.city=?";
        jdbcTemplate.update(sql, city);
    }
}
