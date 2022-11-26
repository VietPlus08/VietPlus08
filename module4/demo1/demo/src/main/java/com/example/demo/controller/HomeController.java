package com.example.demo.controller;

import com.example.demo.Service.IGenderService;
import com.example.demo.models.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired
    IGenderService genderService;

    @GetMapping("")
    public String goList(Model model) {
        model.addAttribute("list", genderService.findAll());
        return "/views/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        // dat ten can trung` voi th:object trong form. vi no can tiem cac thuoc tinh vao` doi tuong
        model.addAttribute("gender", new Gender());
//        model.addAttribute("item",new Gender());
        return "views/create";
    }

    @GetMapping("/find/{id}")
    public String findById(@PathVariable Integer id, Model model) {
        Gender gender = genderService.findById(id);
        model.addAttribute("gender", gender);
        return "views/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
        genderService.deleteById(id);
        attributes.addFlashAttribute("message", "delete success");
        return "redirect:/";
        // 2 dong tren co nghia la xoa roi goi 1 message va goi lai controller voi request "" -> chay lai ham goList cua mi
    }

    @PostMapping("/update")
    public String create(@ModelAttribute("gender") Gender gender, RedirectAttributes attributes){
        genderService.save(gender);
        attributes.addFlashAttribute("message", "update success");
        return "redirect:/";
    }


}
