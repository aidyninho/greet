package com.aidyninho.greet.servlet;

import com.aidyninho.greet.model.User;
import com.aidyninho.greet.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/users/*")
public class GetUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        Long id = Long.parseLong(req.getPathInfo().substring(1));

        UserService userService = UserService.getInstance();
        User user = userService.findById(id);
        resp.getWriter().print(user.toString());
    }
}
