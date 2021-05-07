package com.sunner.springbootapis.client.adv;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class CatController {

    public CatController() {
        getCatFact();
    }


    private Fact getCatFact() {
        RestTemplate restTemplate = new RestTemplate();
        // getForObject() IS GETTING BODY RESPONSE OF PROVIDED Url
        // AND RETURNS RESPONSE BODY SHAPED INTO OBJECT OF YOUR CHOICE
        Fact catFact = restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random",
                Fact.class);
        JsonNode image = restTemplate.getForObject("https://aws.random.cat/meow", JsonNode.class).get("file");
        catFact.setSrc(image.asText());

        return catFact;
    }

    @GetMapping("/cat")
    public String getCat(Model model){
        model.addAttribute("catFact", getCatFact());
        return "view";
    }

}
