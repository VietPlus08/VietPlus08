package com.java.controller;

import java.util.Arrays;
import java.util.List;

import com.java.repos.EmployeeReposImpl;
import com.java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.model.Customer;
import com.java.service.IEmployeeService;

@Controller
@RequestMapping("/")
public class MainController {
    IEmployeeService service;

    public MainController(EmployeeService employeeService) {
        service = employeeService;
    }

    @ModelAttribute("genders")
    public List<String> checkGenders() {
        return Arrays.asList("male", "female", "other");
    }

    @ModelAttribute("marries")
    public List<String> checkMarries() {
        return Arrays.asList("Yes", "No");
    }

    @ModelAttribute("hobbits")
    public List<String> checkHobbits() {
        return Arrays.asList("football", "game", "baseball", "basketball");
    }

    @GetMapping("")
    public String goIndex(Model model) {
        model.addAttribute("customer", new Customer());
        return "index";
    }

    @PostMapping("")
    public String saveCustomer(@ModelAttribute("customer") Customer customer,
                               Model model) {
        model.addAttribute("customer", customer);
        return "list";
    }

    @GetMapping("/check")
    public String ListEmployee(Model model) {
        model.addAttribute("listEmployee", service.findAll());
        return "list";
    }
}
