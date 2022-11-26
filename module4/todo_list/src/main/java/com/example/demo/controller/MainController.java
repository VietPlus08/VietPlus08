package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.model.TodoDTO;
import com.example.demo.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @Autowired
    ITodoService service;

    @GetMapping("")
    public String goList(Model model) {
        model.addAttribute("item", new TodoDTO());
        model.addAttribute("list", service.findAll());
        return "/view/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
        service.updateById(id);
        attributes.addFlashAttribute("message", "hoan thanh cong viec");
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addObject(@ModelAttribute("item") TodoDTO todo) {
        service.save(todo);
        return "redirect:/";
    }
}
