package controller;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import model.*;
import java.util.*;
@WebServlet("/Logout")

public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ssn = request.getSession(true);
        ssn.invalidate();
        RequestDispatcher dispatcher = request.getRequestDispatcher("home-page.jsp");
        dispatcher.forward(request, response);
    }
}
