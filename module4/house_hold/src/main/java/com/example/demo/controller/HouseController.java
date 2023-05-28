package com.example.demo.controller;

import com.example.demo.dao.HouseDao;
import com.example.demo.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HouseController {
    @Autowired
    IHouseService service;

    @GetMapping(" ")
    public String goList(Model model) {
        model.addAttribute("list", service.findAllHouseDto());
        return "/view/home";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("item", new HouseDao());
        return "/view/registry";
    }

    @GetMapping("/delete/{id}")
    public String hideDisplay(@PathVariable Integer id) {
        service.hideDisplay(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("item", service.findByIdDao(id));
        return "/view/registry";
    }

    @PostMapping("/registry")
    public String registry(@ModelAttribute HouseDao houseDao, RedirectAttributes attributes) {
        service.save(houseDao);
        attributes.addFlashAttribute("message", "save successfully!");
        return "redirect:/";
    }


}
