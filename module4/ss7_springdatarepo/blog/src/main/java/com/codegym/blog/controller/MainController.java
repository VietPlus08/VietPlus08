package com.codegym.blog.controller;


import com.codegym.blog.entity.Blog;
import com.codegym.blog.entity.BlogDto;
import com.codegym.blog.service.IBlogService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    final IBlogService service;

    public MainController(IBlogService service) {
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
        model.addAttribute("blog", new BlogDto());
        model.addAttribute("blogs", service.findAll());
        return "view/list";
    }
    @GetMapping("/page_list")
    public String showListWithPage(@PageableDefault(value = 3) Pageable pageable, Model model){
        Sort sort = Sort.by("dateOfCreateComment").descending();
        model.addAttribute("blog", new BlogDto());
        model.addAttribute("blogs", service.findWithPage(pageable));
        return "view/list";
    }

    @PostMapping("/")
    public String addComment(@ModelAttribute("blog") BlogDto blogDto){
        service.save(new Blog(blogDto));
        return "redirect:/";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") Integer id){
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){

        //model.addAttribute("blog",);
        return "view/update";
    }



}
