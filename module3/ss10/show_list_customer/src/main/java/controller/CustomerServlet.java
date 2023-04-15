package controller;

import entity.Customer;
import repo.CustomerRepoImpl;
import repo.IRepo;
import service.CustomerServiceImpl;
import service.IService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer",""})
public class CustomerServlet extends HttpServlet {

    private IService<Customer> service = new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action){
            case "doSave":
                doSave(request,response);
                break;
            case "delete":
                break;
            case "search":
                doSearch(request,response);
                break;
            default:
                findAll(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action){
            case "goRegistryPage":
                goRegistryPage(request,response);
                break;
            case "goUpdatePage":
                goUpdatePage(request,response);
            case "delete":
                doDeleteItem(request,response);
                break;
            default:
                findAll(request, response);
        }

    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchName = request.getParameter("searchName");
        System.out.println(searchName);
        request.setAttribute("list",service.findByIdOrName(searchName));
        request.getRequestDispatcher("/views/customer.jsp").forward(request,response);

    }

    private void doDeleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect("/");
    }

    private void goUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = service.findById(id);

        request.setAttribute("id",id);
        request.setAttribute("name",customer.getName());
        request.setAttribute("age",customer.getAge());
        request.setAttribute("point",customer.getPoint());
        request.setAttribute("img",customer.getImg());
        request.getRequestDispatcher("/views/save.jsp").forward(request,response);
    }

    private void goRegistryPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/views/save.jsp");
    }

    private void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String point = request.getParameter("point");
        String img = request.getParameter("img");

        service.save(new Customer(id,name,age,point,img));
        response.sendRedirect("/");
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",service.findAll());
        request.getRequestDispatcher("/views/customer.jsp").forward(request,response);
    }
}
