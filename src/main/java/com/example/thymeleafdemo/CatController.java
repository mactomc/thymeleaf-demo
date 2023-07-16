package com.example.thymeleafdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CatController {

    private final List<Cat> cats = new ArrayList<>();

    @PostConstruct
    public void onInit(){
        cats.add(new Cat("Fafik", 3));
        cats.add(new Cat("Azor", 4));
    }

    @GetMapping
    public String getCats(Model model){
        model.addAttribute("cats", cats);
        return "cats";
    }

    @GetMapping("/addCat")
    public String addCat() {
        return "addcat";
    }

    @PostMapping("/add")
    public RedirectView addCat(@ModelAttribute("cat") Cat cat){
        cats.add(cat);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");
        return redirectView;
    }

}
