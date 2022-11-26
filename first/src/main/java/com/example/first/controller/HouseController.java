package com.example.first.controller;

import com.example.first.models.HouseHold;
import com.example.first.service.IHouseHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HouseController {
    @Autowired
    IHouseHoldService service;

    @GetMapping("")
    public String goList(Model model){
        model.addAttribute("list",service.findAll());
        return "/views/home";
    }
    @GetMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("house", new HouseHold());
        return "/views/create";
    }

    @GetMapping("/find/{id}")
    public String findById(@PathVariable String id, Model model){
        HouseHold houseHold = service.findById(id);
        model.addAttribute("house",houseHold);
        return "/views/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("house") HouseHold houseHold, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "views/create";
        }
//        service.save(houseHold);
        return "/views/home";
    }

}
