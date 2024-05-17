package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import controller.*;
@WebServlet("/Purchase")
public class Purchase extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ssn = request.getSession(true);
        Customer user = (Customer) ssn.getAttribute("User");

        List<Game> cart = (List<Game>) ssn.getAttribute("Cart");

        PurchaseDOA purchase = new PurchaseDOA();
        try {
            purchase.PurchaseFromCart(cart, user.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher view = request.getRequestDispatcher("home-page.jsp");
        view.forward(request, response);

    }
}
