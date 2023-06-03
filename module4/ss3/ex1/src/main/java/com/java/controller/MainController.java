package com.java.controller;

import com.java.entity.Product;
import com.java.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private ProductService service;

//    public MainController(ProductService service) {
//        this.service = service;
//    }

    @GetMapping("/")
    public String displayList(Model model){
        model.addAttribute("products", service.findAll());
        return "list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,
                         @ModelAttribute("product")Product product,
                         Model model){
        model.addAttribute("product", service.findById(id));
        return "create";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product,
                       Model model){
        service.update(product);
        return "redirect:/";
    }
}
