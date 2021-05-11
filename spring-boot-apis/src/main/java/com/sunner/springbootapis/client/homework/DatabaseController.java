package com.sunner.springbootapis.client.homework;
// HOMEWORK module 5 & 7
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.sunner.springbootapis.client.homework.model.NameHolder;
import com.sunner.springbootapis.client.homework.model.WeatherInfo;
import com.sunner.springbootapis.database.InfoDao;
import com.sunner.springbootapis.database.InfoDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class DatabaseController {


    public WeatherInfo cityInfo;
    public InfoDao infoDao;

    @Autowired
    public DatabaseController(InfoDao infoDao) {
        this.infoDao = infoDao;
        this.cityInfo = getCityInfo("Warsaw");
    }

    private WeatherInfo getCityInfo(String location){

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.metaweather.com/api/location/search/?query=" + location;
        JsonNode locationWoeid = restTemplate.getForObject(url,
                JsonNode.class).findPath("woeid");

        url = "https://www.metaweather.com/api/location/" + locationWoeid.asText();
        WeatherInfo cityInfo = restTemplate.getForObject(url, WeatherInfo.class);

        cityInfo.setImageUrl("https://www.metaweather.com/static/img/weather/png/" +
                cityInfo.getTodayWeather().getWeatherStateAbbr() +".png");

        return cityInfo;
    }

    @GetMapping("/info/weather")
    public String getWeatherInfo(Model model){
        model.addAttribute("dao", this.infoDao);
        model.addAttribute("city", this.cityInfo);
        model.addAttribute("newCity", new NameHolder());
        return "weatherDatabase";
    }

    @PostMapping("/info/updateCity")
    public String updateCity(@ModelAttribute NameHolder newCity){
        this.cityInfo = getCityInfo(newCity.name);
        infoDao.create(this.cityInfo);
        return "redirect:/info/weather";
    }


}
