package com.hackathon.fixAndDeploy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/main.jsp");

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = (String) req.getAttribute("firstName");
        String lastName = (String) req.getAttribute("lastName");
        String mail = (String) req.getAttribute("mail");

        if(firstName != null && lastName != null && mail != null) {
            Password password = new Password(firstName, lastName, mail);
            String pass = password.getPassword(lastName, mail, firstName);
            req.setAttribute("password", pass);
        }
        else {
            req.setAttribute("password", "Try one more time!");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/pass.jsp");
        dispatcher.forward(req, resp);
    }
}
