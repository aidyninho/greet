package com.aidyninho.greet.servlet;

import com.aidyninho.greet.model.User;
import com.aidyninho.greet.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class SaveAndUpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
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

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json");

        Long id = Long.parseLong(req.getParameter("id"));
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");

        User user = new User(id, firstname, lastname);

        UserService userService = UserService.getInstance();
        boolean updated = userService.update(user);

        if (updated) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
