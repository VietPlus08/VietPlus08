package com.java.controller;

import com.java.entity.Comment;
import com.java.entity.CommentDto;
import com.java.service.ICommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    final ICommentService service;

    public MainController(ICommentService service) {
        this.service = service;
    }

    @ModelAttribute("vote")
    public List<Integer> vote(){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        return list;
    }

    @GetMapping("/")
    public String show(Model model){
        model.addAttribute("comment", new CommentDto());
        model.addAttribute("comments", service.findAll());
        return "list";
    }

    @PostMapping("/")
    public String addComment(@ModelAttribute("comment") CommentDto commentDto){
        service.save(commentDto);
        return "redirect:/";
    }

}
