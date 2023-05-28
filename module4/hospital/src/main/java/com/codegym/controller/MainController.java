package com.codegym.controller;

import com.codegym.models.Person;
import com.codegym.service.IBaseService;
import com.codegym.service.impl.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    IBaseService<Person> service = new PersonService();

    @GetMapping("/")
    public String createForm(Model model) {
        model.addAttribute("person", new Person());
        transferDataAddOnForm(model);
        return "/home";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            transferDataAddOnForm(model);
            return "/home";
        }
        service.save(person);
        model.addAttribute("list", service.findAllPerson());
        return "/info";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("person", service.findById(id));
        model.addAttribute("id", id);
        transferDataAddOnForm(model);
        return "/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @Valid @ModelAttribute("person") Person person, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("person", service.findById(id));
            transferDataAddOnForm(model);
            return "/edit";
        }
        service.update(id, person);
        model.addAttribute("list", service.findAllPerson());
        return "/info";
    }


    public void transferDataAddOnForm(Model model) {
        model.addAttribute("listVehicle", service.findAllVehicle());
        model.addAttribute("listGender", service.findAllGender());
        model.addAttribute("listNation", service.findAllNation());
        model.addAttribute("listCity", service.findAllCity());
        model.addAttribute("listDistrict", service.findAllDistrict());
        model.addAttribute("listSubDistrict", service.findAllSubDistrict());
    }
}
