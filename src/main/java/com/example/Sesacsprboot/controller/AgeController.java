package com.example.Sesacsprboot.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgeController {
    @GetMapping("age")
    public String getAge(Model model){
        model.addAttribute("age",18);
        return "Age";
    }
}
