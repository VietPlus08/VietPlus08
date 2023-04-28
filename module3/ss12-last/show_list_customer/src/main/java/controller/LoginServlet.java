package controller;

import entity.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = {"/", "/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doLogin(request,response);
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        boolean remember = Boolean.parseBoolean(request.getParameter("remember"));
        HttpSession session = request.getSession();
        if (user.equals("viet") && password.equals("123")){
            session.setAttribute("account", new Account(user,password));

            if (remember){
                Cookie userCookie = new Cookie("username",user);
                Cookie passCookie = new Cookie("password",password);
                userCookie.setMaxAge(3600);
                passCookie.setMaxAge(3600);
                response.addCookie(userCookie);
                response.addCookie(passCookie);
            }

            response.sendRedirect("/customer");
        }
        else {
            response.sendRedirect("/login?message=Login failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action){
            case "logout":
                logout(request,response);
                break;
            default:
                loginForm(request, response);
        }
    }

    private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        request.setAttribute("message",message);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("account");
        response.sendRedirect("/login?message=Logout");
    }
}
