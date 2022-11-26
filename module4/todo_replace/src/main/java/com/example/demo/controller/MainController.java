package com.example.demo.controller;

import com.example.demo.DTO.TodoDTO;
import com.example.demo.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    IService service;

    @GetMapping(" ")
    public String goList(Model model) {
        model.addAttribute("item", new TodoDTO());
        model.addAttribute("list", service.findAllDTO());
        return "/view/home";
    }

    @GetMapping("/update/{id}")
    public String updateById(@PathVariable Integer id, RedirectAttributes attributes) {
        service.updateById(id);
        attributes.addFlashAttribute("message", "Hoan thanh cong viec");
        return "redirect:/";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("item") TodoDTO todoDTO, BindingResult result,
                      RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("list", service.findAllDTO());
            return "/view/home";
        }
        service.save(todoDTO);
        attributes.addFlashAttribute("message", "Cap nhat cong viec moi");
        return "redirect:/";
    }
}
