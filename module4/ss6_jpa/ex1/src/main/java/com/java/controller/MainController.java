package com.java.controller;

import com.java.entity.Blog;
import com.java.entity.BlogDto;
import com.java.service.IBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    final IBlogService service;

    public MainController(IBlogService service) {
        this.service = service;
    }

    @ModelAttribute("vote")
    public List<Integer> vote(){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        return list;
    }

    @GetMapping("/")
    public String show(Model model){
        model.addAttribute("blog", new BlogDto());
        model.addAttribute("blogs", service.findAll());
        return "list";
    }

    @PostMapping("/")
    public String addComment(@ModelAttribute("blog") BlogDto blogDto){
        service.save(new Blog(blogDto));
        return "redirect:/";
    }

}
