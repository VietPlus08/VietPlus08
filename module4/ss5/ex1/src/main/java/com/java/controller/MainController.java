package com.java.controller;

import com.java.service.ISongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    final ISongService songService;

    public MainController(ISongService songService) {
        this.songService = songService;
    }

    @GetMapping("/")
    public String showDetail(Model model){
        model.addAttribute("songs",songService.findAll());
        return "list";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("song",songService.findById(id));
        return "update";
    }

}
