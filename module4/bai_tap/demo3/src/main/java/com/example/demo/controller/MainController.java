package com.example.demo.controller;

import com.example.demo.dto.BorrowingDto;
import com.example.demo.entities.Book;
import com.example.demo.entities.Borrow;
import com.example.demo.entities.Student;
import com.example.demo.service.IBookService;
import com.example.demo.service.IBorrowService;
import com.example.demo.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final IBookService bookService;
    private final IBorrowService borrowService;
    private final IStudentService studentService;
    public MainController(IBookService bookService, IBorrowService borrowService, IStudentService studentService) {
        this.bookService = bookService;
        this.borrowService = borrowService;
        this.studentService = studentService;
    }

    @GetMapping("")
    public String display(Model model){
        model.addAttribute("books",bookService.findAll());
        return "views/index";
    }

    @PostMapping("save")
    public String saveBorrowing(@ModelAttribute("borrow") @Valid BorrowingDto borrow, BindingResult result,
                                @ModelAttribute("book") Book book,
                                @ModelAttribute("student") Student student,
                                Model model,
                                RedirectAttributes attributes){
        if (result.hasErrors()){
            List<Student> studentList = studentService.findAll();
            model.addAttribute("students", studentList);
            return "views/create_borrowing";
        }
//        borrowService.save(borrow,book.getName());
        borrowService.saveDto(borrow);
        attributes.addFlashAttribute("message","Borrow Successfully!");
        return "redirect:/";
    }

    @GetMapping(value = "create/{id}")
    public String goCreatePage(@PathVariable("id") String id, Model model){
        Book book = bookService.findById(id);
        List<Student> studentList = studentService.findAll();
        Borrow borrow = new Borrow();
        borrow.setBook(book);
        model.addAttribute("book", book);
        model.addAttribute("students", studentList);
        model.addAttribute("borrow", new BorrowingDto(borrow));
        return "views/create_borrowing";
    }

//    @GetMapping(value = "/login")
//    public String login(){
//        return "views/login";
//    }

    @GetMapping(value = "borrowing")
    public String goBorrowingList(Model model){
        model.addAttribute("borrows", borrowService.findAllBorrowing());
        return "views/borrowing_list";
    }

    @GetMapping(value = "borrowing/return/{id}")
    public String returnBook(@PathVariable("id") String id,
                             Model model,
                             RedirectAttributes attributes){
        borrowService.returnBook(id);
        attributes.addFlashAttribute("message","Returned successfully!");
        return "redirect:/borrowing";
    }

}
