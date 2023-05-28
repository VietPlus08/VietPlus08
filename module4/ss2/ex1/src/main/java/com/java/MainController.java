package com.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @ModelAttribute("condimentNames")
    public List<String> condimentNames(){
        List<String> name = Arrays.asList("Lettuce","Tomato","Mustard","Sprouts");
        return name;
    }

    @GetMapping("/")
    public String displayListCondiment(Model model){
        model.addAttribute("condiment", new Condiment());
        return "index";
    }

    @GetMapping("/save")
    public String showDetail(@ModelAttribute("condiment") Condiment condiment){
        return "show";
    }

}
