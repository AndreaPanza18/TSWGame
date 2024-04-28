package controller;
import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import model.*;
import java.util.*;
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Customer c = new Customer();
        CustomerDOA create = new CustomerDOA();
        c.setName(request.getParameter("name"));
        c.setLastName(request.getParameter("lastName"));
        c.setEmail(request.getParameter("email"));
        c.setPassword(request.getParameter("password"));

        if(create.CreateAccount(c)){
            out.println("<html><body>");
            out.println("<p>" + c.getName() + " benvenuto</p>");
            out.println("</html></body>");
        }
        else{
            out.println("<html><body>");
            out.println("<p>ERROR: INVALID INPUT</p>");
            out.println("</html></body>");
        }
    }
}
