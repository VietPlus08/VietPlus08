package com.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class controller {

    private static Map<String, String> dictionary = new HashMap<>();
    static {
        dictionary.put("one","mot");
        dictionary.put("two","hai");
        dictionary.put("three","ba");
        dictionary.put("four","bon");
        dictionary.put("five","nam");
    }

    @GetMapping("/")
    public String displayDetails(){
        return "index";
    }

    @GetMapping("/change")
    public String change(@RequestParam("findWord") String findWord, Model  model){
        String resultWord = dictionary.get(findWord);
        model.addAttribute("resultWord",resultWord);
        return "index";
    }
}
