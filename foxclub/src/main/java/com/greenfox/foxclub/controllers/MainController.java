package com.greenfox.foxclub.controllers;

import com.greenfox.foxclub.models.Drink;
import com.greenfox.foxclub.models.Food;
import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class MainController {
    private FoxService foxService;

    @Autowired
    public MainController(FoxService foxService) {
        this.foxService = foxService;
    }


    @GetMapping("/")
    public String getIndexPage(Model model, @RequestParam Optional<String> name) {
        if (name.isEmpty() || name.get().isEmpty()) {
            return "redirect:/login";
        }
        if(foxService.getFox(name.get()) == null) {
            return "redirect:/login";
        }
        model.addAttribute("foxObject", foxService.getFox(name.get()));
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String submitLoginForm(@RequestParam String name, RedirectAttributes redirectAttributes) {
        foxService.tryToAccommodateNewFox(name);
        redirectAttributes.addAttribute("name", name);
        return "redirect:/";
    }

    @GetMapping("/nutritionStore")
    public String getNutritionStorePage(Model model, @RequestParam Optional<String> name) {
        if (name.isEmpty()) {
            return "redirect:/login";
        }
        Fox fox = foxService.getFox(name.get());
        if(fox == null) {
            return "redirect:/login";
        }
        model.addAttribute("foxObject", fox);
        return "nutritionStore";
    }

    @PostMapping("/nutritionStore")
    public String submitNutritionForm(Model model, @RequestParam Food petFood, @RequestParam Drink petDrink, @RequestParam String name, RedirectAttributes redirectAttributes){
        Fox fox = foxService.getFox(name);
        if(fox == null) {
            return "redirect:/login";
        }
        model.addAttribute("foxObject", fox);
        redirectAttributes.addAttribute("name", name);
        foxService.setFood(fox, petFood);
        foxService.setDrink(fox, petDrink);
        return "redirect:/";
    }

    @GetMapping("/trickCenter")
    public String getTrickCenterPage(Model model, @RequestParam Optional<String> name) {
        if (name.isEmpty()) {
            return "redirect:/login";
        }
        Fox fox = foxService.getFox(name.get());
        if(fox == null) {
            return "redirect:/login";
        }
        model.addAttribute("foxObject", fox);
        model.addAttribute("availableTricks", foxService.getLearnableTricks(name.get()));
        return "trickCenter";
    }

    @PostMapping("/trickCenter")
    public String submitTrickForm(Model model, @RequestParam String trick, @RequestParam String name, RedirectAttributes redirectAttributes) {
        model.addAttribute("foxObject", foxService.getFox(name));
        redirectAttributes.addAttribute("name", name);
        foxService.setLearnableTrick(name, trick);
        return "redirect:/";
    }

}
