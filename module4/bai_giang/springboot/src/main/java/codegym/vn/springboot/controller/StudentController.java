package codegym.vn.springboot.controller;

import codegym.vn.springboot.entity.ClassName;
import codegym.vn.springboot.entity.Student;
import codegym.vn.springboot.service.ClassNameService;
import codegym.vn.springboot.service.StudentService;
import codegym.vn.springboot.validate.StudentValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @Autowired
    private ClassNameService classNameService;


    @GetMapping(value = "/list"
//        consumes = {MediaType.APPLICATION_JSON_VALUE}
//            ,headers = {"Content-Type=text/html","Accept=application/xml"}
            )
    public String list(Model model) {
        List<Student> students = service.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }

//    @GetMapping("/view/{student_id}")
//    public String viewStudent(@PathVariable("student_id") String id, Model model) {
//        Student student = service.findById(id);
//        model.addAttribute("student", student);
//        return "/student/view";
//    }

    // Dùng formatter
    @GetMapping("/view/{student_id}")
    public String viewStudent(@PathVariable("student_id") Student student, Model model) {
        model.addAttribute("student", student);
        return "/student/view";
    }

    @GetMapping("/update/{student_id}")
    public String updateStudent(@PathVariable("student_id") Student student, Model model) {
        List<ClassName> classNames = classNameService.findAll();
        model.addAttribute("classNames", classNames);
        model.addAttribute("student", student);
        return "/student/create";
    }

    @GetMapping("/view")
    public String viewStudentByParam(@RequestParam("id") String id, Model model) {
        Student student = service.findById(id);
        model.addAttribute("student", student);
        return "/student/view";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        List<ClassName> classNames = classNameService.findAll();
        Student student = new Student();
        student.setClassName(new ClassName());
        model.addAttribute("student", student);
        model.addAttribute("classNames", classNames);
        return "/student/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("student") Student student,
                         BindingResult bindingResult, Model model) {
        StudentValidate validate = new StudentValidate();
        validate.validate(student, bindingResult);
        if (bindingResult.hasErrors()) {
            List<ClassName> classNames = classNameService.findAll();
            model.addAttribute("classNames", classNames);
            if (student.getClassName() == null) {
                student.setClassName(new ClassName());
            }
            return "/student/create";
        }
        service.create(student);
        return "redirect:/student/list";
    }

    @PostMapping("/create2")
    public String create2(@RequestParam("id") String id,
                          @RequestParam("name") String name
                          ,RedirectAttributes redirectAttributes
    ) {
        Student student = new Student(id, name);
        service.create(student);
        System.out.println("Create student success");
        redirectAttributes.addFlashAttribute("students", service.findAll());
        return "redirect:/student/list2";
    }

    @GetMapping(value = "/listpaging")
    public String listpaging(Model model, @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size,
                             @RequestParam("sort") Optional<String> sort) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("phoneNumber");
        Sort sortBy = Sort.by("email").descending().and(Sort.by("phoneNumber").ascending());
        Page<Student> students = service.findAllWithPaging(PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));
        model.addAttribute("students", students);
        int totalPages = students.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "student/listPaging";
    }

    @GetMapping(value = "/listpagingslice")
    public String listpagingslice(Model model, @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Slice<Student> students = service.findAllWithSlice(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("students", students.getContent());
        model.addAttribute("page", students);
        return "student/listPagingSlice";
    }
}
