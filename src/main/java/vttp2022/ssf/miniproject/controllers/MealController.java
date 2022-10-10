package vttp2022.ssf.miniproject.controllers;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vttp2022.ssf.miniproject.models.Meal;
import vttp2022.ssf.miniproject.services.MealService;

@Controller
public class MealController {

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping(path={"/home"})
    public String getMeal(Model model) {
        List<Meal> meal = MealService.getMeal();
        model.addAttribute("meal", meal);
        return "home";
    }

}



    

