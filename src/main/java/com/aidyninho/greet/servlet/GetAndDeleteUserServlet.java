package com.aidyninho.greet.servlet;

import com.aidyninho.greet.model.User;
import com.aidyninho.greet.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/users/*")
public class GetAndDeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json");
        Long id = Long.parseLong(req.getPathInfo().substring(1));

        UserService userService = UserService.getInstance();
        Optional<User> user = userService.findById(id);

        user.ifPresentOrElse(user1 -> {
                    try {
                        resp.getWriter().print(user1);
                        resp.setStatus(HttpServletResponse.SC_OK);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }, () -> resp.setStatus(HttpServletResponse.SC_BAD_REQUEST)

        );
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json");

        Long id = Long.parseLong(req.getPathInfo().substring(1));

        UserService userService = UserService.getInstance();
        boolean deleted = userService.delete(id);

        if (deleted) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
