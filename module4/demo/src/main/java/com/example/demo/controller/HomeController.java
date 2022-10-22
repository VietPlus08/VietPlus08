package com.example.demo.controller;

import com.example.demo.Service.IGenderService;
import com.example.demo.models.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    IGenderService genderService;

    @GetMapping("")
    public String goList(Model model) {
        model.addAttribute("list",genderService.findAll());
        return "/views/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("item",new Gender());
        return "/views/create";
    }

    @GetMapping("/find/{id}")
    public String findById(@PathVariable String id, Model model){
        Gender gender = genderService.findById(id);
    }

}
