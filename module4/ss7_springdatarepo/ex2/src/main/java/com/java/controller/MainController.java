package com.java.controller;

import com.java.entity.Comment;
import com.java.service.ICommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", service.findAll());
        return "list";
    }

    @PostMapping("/")
    public String addComment(@ModelAttribute("comment") Comment comment){
        Comment injectComment = new Comment();
        injectComment.setMark(comment.getMark());
        injectComment.setAuthor(comment.getAuthor());
        injectComment.setFeedback(comment.getFeedback());
        service.save(injectComment);
        return "redirect:/";
    }

    @GetMapping("/pagedList")
    public String pagedListShow(Model model,
                                @RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size,
                                @RequestParam("sort") Optional<String> sort){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("dateOfCreateComment");
        Pageable sortByTime = PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).descending());
        Page<Comment> comments = service.findAllWithPages(sortByTime);

        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", comments);

        int totalPages = comments.getTotalPages();
        if (totalPages > 1){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "pagedList";


    }


}
