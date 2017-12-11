package com.akhambir.controller;

import com.akhambir.model.User;
import com.akhambir.service.UserService;
import com.akhambir.web.ViewModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserController implements Controller {

    private UserService userService;

    public CreateUserController(UserService userService) {
        this.userService = userService;
    }


    @Override
    public ViewModel process(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }


    public User create(User user) {
        return userService.create(user);
    }
}
