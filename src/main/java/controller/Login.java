package controller;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import model.*;
import java.util.*;
@WebServlet("/Login")

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Customer c;
        CustomerDOA checkLogin = new CustomerDOA();
        c = checkLogin.loginUser(email, password);

        if(c == null){
            out.println("<html><body>");
            out.println("<p>Error: Quest'account non esiste</p>");
            out.println("</html></body>");
        }else{
            out.println("<html><body>");
            out.println("<p>" + c.getName() + " bentornato</p>");
            out.println("</html></body>");
        }
    }
}
