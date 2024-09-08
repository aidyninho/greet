package com.aidyninho.greet.servlet;

import com.aidyninho.greet.model.User;
import com.aidyninho.greet.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/users")
public class SaveUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");

        User user = new User(null, firstname, lastname);

        UserService userService = UserService.getInstance();
        boolean saved = userService.save(user);

        if (saved) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
