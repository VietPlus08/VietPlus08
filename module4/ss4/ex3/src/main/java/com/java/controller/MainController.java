package com.java.controller;

import com.java.entity.Communication;
import com.java.entity.Declaration;
import com.java.repo.ICommunicationRepo;
import com.java.repo.IVehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    ICommunicationRepo communicationRepo;

    @Autowired
    IVehicleRepo vehicleRepo;


    @ModelAttribute("year")
    public List<Integer> year(){
        List<Integer> list = new ArrayList<>();
        for (int i = 1990; i <2200 ; i++) {
            list.add(i);
        }
        return list;
    }
    @GetMapping("/")
    public String showDeclaration(Model model){
        model.addAttribute("mes", "tai sao lai the");
        model.addAttribute("declaration", new Declaration());
        model.addAttribute("communications", communicationRepo.findAll());
        model.addAttribute("vehicles", vehicleRepo.findAll());

        return "edit";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("declaration") Declaration declaration){

        return "redirect:/";
    }
}
