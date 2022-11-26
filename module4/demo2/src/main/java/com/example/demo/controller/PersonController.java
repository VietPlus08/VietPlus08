package com.example.demo.controller;

import com.example.demo.services.IPersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {
    @Autowired
    IPersonServices services;

    @GetMapping("")
    public String goList(){


        return "/views/home";
    }

}
