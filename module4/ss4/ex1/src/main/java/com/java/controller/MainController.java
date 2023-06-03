package com.java.controller;

import com.java.entity.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.*;

@Controller
public class MainController {

    @ModelAttribute("pages")
    public List<Integer> pages(){
        Integer[] arr = {5,10,15,25};
        return Arrays.asList(arr);
    }

    @ModelAttribute("languages")
    public List<String> languages(){
        String[] arr = {"English","Vietnamese","Chinese"};
        return Arrays.asList(arr);
    }

    @GetMapping("/")
    public String edit(Model model){
        model.addAttribute("mail", new Mail(15,"English","Enable spams filter","Thor King Asgards"));
        return "edit";
    }

}
