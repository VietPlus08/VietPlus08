package com.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {

    @GetMapping("/")
    public String displayDetails(){
        return "index";
    }

    @GetMapping("/change")
    public String change(@RequestParam("sourceNumber") int number, Model  model){
        int targetNumber = number/23000;
        model.addAttribute("resultNumber",targetNumber);
        return "index";
    }
}
