package vttp2022.ssf.miniproject.controllers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MealAController {

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

//     @GetMapping("/")
//     public String retrieveMeal(Model model) {
//     RestTemplate template = new RestTemplate();
//     String URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=chicken";
//     ResponseEntity<HashMap> responseEntity = template.getForEntity(URL,Meal.class);
//     ArrayList<Meal> Array = responseEntity.getBody().;
//     System.out.println(Array);
//     return "index";
// }


    
}
