package com.akhambir.controller;

import com.akhambir.model.User;
import com.akhambir.service.UserService;
import com.akhambir.web.ViewModel;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.akhambir.web.Methods.GET;

public class LoginUserController implements Controller {

    private UserService userService;

    public LoginUserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(HttpServletRequest request, HttpServletResponse response) {
        ViewModel vm = new ViewModel("login");
        if (request.getMethod().equals(GET.toString())) {
            return vm;
        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String token = userService.checkUser(email, password)
                .orElse("unauthorized");

        response.addCookie(new Cookie("MyApp", token));
        return vm;
    }


}
