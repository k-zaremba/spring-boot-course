package com.sunner.springbootapis.client.basic;

import com.sunner.springbootapis.api.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@Controller
public class CarClient {

    private RestTemplate restTemplate;

    public CarClient(){
        this.restTemplate = new RestTemplate();
    }

    // CLIENT SIDE GET METHOD USING HEADER PARAM
    private Car[] getCarsAmount(int amount){
        // HEADERS ARE REPRESENTED BY MultiValUeMap
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("amount", Integer.valueOf(amount).toString());

        // THEN ADDED TO HttpEntity (OBJECT CONSISTING OF HEADER AND BODY USED FOR REQUEST)
        HttpEntity httpEntity = new HttpEntity(headers);

        // RESPONSE FROM API WITH BODY, STATUS, ETC.
        // USES EXCHANGE METHOD TO PERFORM SPECIFIED HTTP METHOD
        // CHOSE URL, HTTP METHOD
        // GIVE HttpEntity
        // RECEIVE RESPONSE BODY SHAPED INTO OBJECT OF YOUR CHOICE
        ResponseEntity<Car[]> exchange = restTemplate.exchange("http://localhost:8080/cars/amount",
                HttpMethod.GET,
                httpEntity,
                Car[].class);

        // UNCOMMENT FOR RESULT
        //Stream.of(exchange.getBody()).forEach(System.out::println);

        return exchange.getBody();
    }

    // CLIENT SIDE POST METHOD USING BODY PARAM
    //@EventListener(ApplicationReadyEvent.class)
    public void addCar(){

        Car car = new Car(8L,"Porsche", "Blue");

        HttpEntity<Car> httpEntity = new HttpEntity<>(car);

        restTemplate.exchange("http://localhost:8080/cars",
                HttpMethod.POST,
                httpEntity,
                Void.class);
    }

    @GetMapping("/presentation/{amount}")
    public String presentCars(Model model, @PathVariable int amount){
        model.addAttribute("carsArray", getCarsAmount(amount));

        return "carsPresentation";
    }
}
