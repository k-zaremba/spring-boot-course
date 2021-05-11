package com.sunner.springbootapis.client.basic;

import com.sunner.springbootapis.client.basic.model.CovidInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class CovidController {

    public CovidController() {
    }

    private CovidInfo[] getFullInfo() {
        RestTemplate restTemplate = new RestTemplate();
        // getForObject() IS GETTING BODY OF PROVIDED Url RESPONSE
        // AND RETURNS RESPONSE BODY SHAPED INTO OBJECT OF YOUR CHOICE
        CovidInfo[] fullInfo = restTemplate.getForObject("https://api.covid19api.com/total/dayone/country/PL",
                CovidInfo[].class);
        return fullInfo;
    }

    @GetMapping("/covidInfo")
    public String getInfo(Model model){
        model.addAttribute("fullInfo", getFullInfo());
        return "covidInfo";
    }
}
