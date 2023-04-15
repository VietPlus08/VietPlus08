package com.example.ex1_product;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/solution")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");
        System.out.println(description);
        System.out.println(price);
        System.out.println(discount);
        request.setAttribute("description", description);
        request.setAttribute("price", price);
        request.setAttribute("discount", discount);
        request.getRequestDispatcher("solution.jsp").forward(request,response);

    }

    public void destroy() {
    }
}