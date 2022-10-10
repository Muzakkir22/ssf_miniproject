package vttp2022.ssf.miniproject.controllers;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.ssf.miniproject.models.Meal;
import vttp2022.ssf.miniproject.services.MealService;

@Controller
public class MealController {

    public String user;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping(path={"/home"})
    public String getMeal(Model model, @RequestParam("loginUser") String userName) {
        List<Meal> meal = MealService.getMeal();
        this.user=userName;
        model.addAttribute("meal", meal);
        model.addAttribute("user", userName);
        return "home";
    }

    @GetMapping("/search")
    public String getSearch(Model model, @RequestParam("word") String userSearch) {
        List<Meal> meal = MealService.getMeal(userSearch);
        System.out.println(userSearch);
        model.addAttribute("meal", meal);
        return "search";
    }

    @GetMapping("/save")
    public String save(@RequestParam("checkbox") List<String> foodName) {
        System.out.println(foodName);
        return "save";
    }

}



    

