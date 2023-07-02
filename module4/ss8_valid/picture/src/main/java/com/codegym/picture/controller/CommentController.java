package com.codegym.picture.controller;

import com.codegym.picture.entity.Comment;
import com.codegym.picture.service.CommentService;
import com.codegym.picture.validate.CommentValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CommentController {

    final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showAll(Model model,
                          @RequestParam("page")Optional<Integer> page){
        int currenPage = page.orElse(1);
        int pageSize = 5;
        Pageable pageable = PageRequest.of(currenPage - 1, pageSize, Sort.by("timeOfCreateComment"));
        model.addAttribute("comments",service.findAllWithPages(pageable));
        model.addAttribute("comment",new Comment());
        return "view/list";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("comment") Comment comment,
                         BindingResult result,
                         @RequestParam("page")Optional<Integer> page,
                         Model model){
        CommentValidator validator = new CommentValidator();
        validator.validate(comment, result);
        if (result.hasErrors()){
            int currenPage = page.orElse(1);
            int pageSize = 5;
            Pageable pageable = PageRequest.of(currenPage - 1, pageSize, Sort.by("timeOfCreateComment"));
            model.addAttribute("comments",service.findAllWithPages(pageable));
            model.addAttribute("comment",comment);
            return "view/list";
        }
        service.save(comment);
        return "redirect:/";
    }
}
