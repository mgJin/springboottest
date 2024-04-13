package com.mgjinproject.showstack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FirstController {
    
    @GetMapping("/g1r")
    public String metyou(Model model){
        model.addAttribute("username", "mgJin");
        
        return "greetingss";
    }

    @GetMapping("/home1")
    public String getHome(Model model) {
        model.addAttribute("user", "Jin");
        return "home";
    }
    
}
