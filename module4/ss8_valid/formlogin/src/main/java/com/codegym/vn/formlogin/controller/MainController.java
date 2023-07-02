package com.codegym.vn.formlogin.controller;

import com.codegym.vn.formlogin.entity.Infor;
import com.codegym.vn.formlogin.entity.Job;
import com.codegym.vn.formlogin.exception.DuplicateIdentityNumberException;
import com.codegym.vn.formlogin.service.IJobService;
import com.codegym.vn.formlogin.service.IService;
import com.codegym.vn.formlogin.validate.InforValidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/")
public class MainController {

    final IService service;
    final IJobService jobService;

    public MainController(IService service, IJobService jobService) {
        this.service = service;
        this.jobService = jobService;
    }


    @GetMapping("/")
    public String showAll(Model model,
                          @RequestParam("page") Optional<Integer> page,
                          @RequestParam("size") Optional<Integer> size,
                          @RequestParam("sort") Optional<Integer> sort){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage - 1,
                pageSize,
                Sort.by("name").descending().and(Sort.by("address").descending()));
        Page<Infor> infors = service.findAllWithPaging(pageable);
        model.addAttribute("infors", infors);
        int totalPages = infors.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "view/list";
    }

    @GetMapping("/save")
    public String goForm(Model model) {
        Infor infor = new Infor();
        Job job = new Job();
        infor.setJob(job);
        model.addAttribute("infor", infor);
        model.addAttribute("jobs", jobService.findAll());
        return "view/form";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("infor") Infor infor,
                       BindingResult result,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        InforValidate validate = new InforValidate();
        validate.validate(infor,result);
        if (result.hasErrors()){
            if (infor.getJob() == null){
                infor.setJob(new Job());
            }
            model.addAttribute("infor", infor);
            model.addAttribute("jobs", jobService.findAll());
            return "view/form";
        }

        try {
            service.save(infor);
        } catch (DuplicateIdentityNumberException e) {
            return "view/input_not_acceptable";
        }
        redirectAttributes.addFlashAttribute("message", "add successfully!");
        return "redirect:/";
    }
}
