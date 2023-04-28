package controller;

import entities.Product;
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

@WebServlet(name = "ProductServlet", urlPatterns = "/productServlet")
public class ProductServlet extends javax.servlet.http.HttpServlet {
    private IService<Product> service = new ProductServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("Vao doget: " + LocalTime.now());
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action){
            case "goCreatePage":
                goCreatePage(request,response);
                break;
            case "search":
            default:
                findAll(request,response);
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index = Optional.ofNullable(request.getParameter("index")).orElse("1");
        String message = Optional.ofNullable(request.getParameter("message")).orElse("");
        String searchName = Optional.ofNullable(request.getParameter("searchName")).orElse("");

        request.setAttribute("index",index);
        request.setAttribute("message",message);
        request.setAttribute("pages",service.countAllFromProduct());
        request.setAttribute("list",service.findAll(searchName, Integer.parseInt(index)));
        request.getRequestDispatcher("/views/product.jsp").forward(request,response);
    }

    private void goCreatePage(HttpServletRequest request, HttpServletResponse response) {
    }
}
