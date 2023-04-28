package controller;

import entity.Account;
import entity.Customer;
import service.CustomerServiceImpl;
import service.IService;
import utils.Valid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private IService<Customer> service = new CustomerServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        super.service(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "doSave":
                doSave(request, response);
                break;
            default:
                findAll(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("vao do get: " + LocalTime.now());
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            Cookie[] cookies = request.getCookies();

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    request.setAttribute("username",cookie.getValue());
                }
                if (cookie.getName().equals("password")) {
                    request.setAttribute("password",cookie.getValue());
                }
            }
            request.setAttribute("message","Please login");
            request.getRequestDispatcher("/login").forward(request,response);
            System.out.println("Vao login lai: " + LocalTime.now());
            return;
        }
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "goRegistryPage":
                goRegistryPage(request, response);
                break;
            case "goUpdatePage":
                goUpdatePage(request, response);
                break;
            case "delete":
                doDeleteItem(request, response);
                break;
            case "search":
            default:
                findAll(request, response);
        }
    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchId = request.getParameter("searchId");
        String searchName = request.getParameter("searchName");
        String index = Optional.ofNullable(request.getParameter("index")).orElse("1");
        request.setAttribute("list", service.findByIdOrName(searchId, searchName, index));
        request.getRequestDispatcher("/views/customer.jsp").forward(request, response);
    }

    private void doDeleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (service.delete(id)) {
            response.sendRedirect("/customer?message=Delete successfully!");
        }
    }

    private void goUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = service.findById(id);
        request.setAttribute("item",customer);
        request.getRequestDispatcher("/views/save.jsp").forward(request, response);
    }

    private void goRegistryPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/views/save.jsp");
    }

    private void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String point = request.getParameter("point");
        String img = request.getParameter("img");

        Customer customer = new Customer(id, name, age, point, img);
        Map<String, String> errorMap = Valid.getValidation(customer);
        if (errorMap.isEmpty()){
            service.save(customer);
            response.sendRedirect("/customer?message=Save Successfully!");
            return;
        }
        request.setAttribute("error",errorMap);
        request.setAttribute("message","Save fail!");
        request.setAttribute("item",customer);
        request.getRequestDispatcher("/views/save.jsp").forward(request,response);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        String index = Optional.ofNullable(request.getParameter("index")).orElse("1");
        String searchId = Optional.ofNullable(request.getParameter("searchId")).orElse("");
        String searchName = Optional.ofNullable(request.getParameter("searchName")).orElse("");
        request.setAttribute("index", index);
        request.setAttribute("pages", service.pages());
        request.setAttribute("message", message);
        request.setAttribute("list", service.findByIdOrName(searchId, searchName, index));
        request.getRequestDispatcher("/views/customer.jsp").forward(request, response);
    }
}
