package controller;

import entities.Category;
import entities.Product;
import service.CategoryServiceImpl;
import service.IService;
import service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Optional;

@WebServlet(name = "ProductServlet", urlPatterns = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private IService<Product> service = new ProductServiceImpl();
    private CategoryServiceImpl categoryService = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Vao do post: "+ LocalTime.now());
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action){
            case "doSave":
                doSave(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            default:
                findAll(request,response);
        }}

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect("/ProductServlet");
    }

    private void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product product = new Product(id,name,price,quantity,color,description,categoryId);
        service.save(product);
        response.sendRedirect("/ProductServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Vao do get: "+ LocalTime.now());
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action){
            case "goCreatePage":
                goCreatePage(request,response);
                break;
            case "goUpdatePage":
                goUpdatePage(request,response);
                break;
            default:
                findAll(request,response);
        }

    }

    private void goUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("categories",categoryService.findAll());
        request.setAttribute("item",service.findById(id));
        request.getRequestDispatcher("/views/save.jsp").forward(request,response);
    }

    private void goCreatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories",categoryService.findAll());
        request.getRequestDispatcher("/views/save.jsp").forward(request,response);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index = Optional.ofNullable(request.getParameter("index")).orElse("1");
        String message = request.getParameter("message");
        String searchName = Optional.ofNullable(request.getParameter("searchName")).orElse("");
        request.setAttribute("index",index);
        request.setAttribute("message",message);
        request.setAttribute("searchName",searchName);
        request.setAttribute("pages",service.pages());
        request.setAttribute("products",service.findAll(searchName, index));
        request.setAttribute("categories",categoryService.findAll());
        request.getRequestDispatcher("/views/list.jsp").forward(request,response);


    }
}
