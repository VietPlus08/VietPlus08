package com.java.controller;

import com.java.entities.Employee;
import com.java.service.EmployeeServiceImpl;
import com.java.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
     private IService employeeService;

    @GetMapping("employee-view")
    public String display(Model model){
        model.addAttribute("listEmployee",employeeService.findAll());
        return "employee-view";
    }

    @GetMapping("employee-update/{id}")
    public String update(@PathVariable("id") String id, Model model){
        Employee employee = (Employee) employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "employee-save";
    }

    @GetMapping("employee-add")
    public String addNew(Model model){
        model.addAttribute("employee", new Employee());
        return "employee-save";
    }

    @GetMapping("employee-delete/{id}")
    public String delete(@PathVariable("id") String id, Model model){
        Employee employee = (Employee) employeeService.getById(id);
        employeeService.delete(employee);
        model.addAttribute("message","delete successfully!");
        return "redirect:/employee-view";
    }

    @PostMapping("saveEmployee")
    public String update(@ModelAttribute("employee") @Valid Employee employee, BindingResult result, Model model){
        if (result.hasErrors()){
            return "employee-save";
        }
        employeeService.save(employee);
        model.addAttribute("message","save successfully!");
        return "redirect:/employee-view";
    }
}
