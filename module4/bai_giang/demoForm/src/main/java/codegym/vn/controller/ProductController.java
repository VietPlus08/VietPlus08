package codegym.vn.controller;

import codegym.vn.entity.Product;
import codegym.vn.repository.CategoryRepository;
import codegym.vn.repository.ProductRepository;
import codegym.vn.service.CategoryService;
import codegym.vn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PreUpdate;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productRepository;
    @Autowired
    private CategoryService categoryRepository;
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product_thymleaf/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryRepository.findAll());
        return "product_thymleaf/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("product") Product product) {
        product.setCategory(categoryRepository.findById(product.getCategory().getCategoryId()));
        productRepository.create(product);
        return "redirect:/product/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model,
                             @PathVariable("id") int id) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "product_thymleaf/detail";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "product_thymleaf/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product) {
        product.setCategory(categoryRepository.findById(product.getCategory().getCategoryId()));
        productRepository.update(product);
        return "redirect:/product/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Product> productList = productRepository.findProductByName(name);
        model.addAttribute("products", productList);
        model.addAttribute("name", name);
        return "product_thymleaf/list";
    }
}
