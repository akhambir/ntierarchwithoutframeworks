package com.akhambir.web;

import com.akhambir.Factory;
import com.akhambir.controller.Controller;
import com.akhambir.controller.CreateUserController;
import com.akhambir.controller.LoginUserController;
import com.akhambir.dao.UserDaoImpl;
import com.akhambir.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {

    private static final Map<Request, Controller> controllerMap = new HashMap<>();


    public void init() {
        controllerMap.put(new Request("/login", "POST"), Factory.getSomething(CreateUserController::new)
                .compose(UserServiceImpl::new)
                .compose(UserDaoImpl::new)
                .apply(Factory.getConnection()));
        controllerMap.put(new Request("/login", "GET"), Factory.getSomething(LoginUserController::new)
                .compose(UserServiceImpl::new)
                .compose(UserDaoImpl::new)
                .apply(Factory.getConnection()));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        /*if (request.getRequestURI().equals("/servlet/home")) {
            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        } else if (request.getRequestURI().equals("/servlet/form")) {
            request.getRequestDispatcher("/WEB-INF/formExample.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }*/
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Request request = new Request(req.getRequestURI(), req.getMethod());

        Controller controller = controllerMap.get(request);

        if (controller == null) {
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, res);
        }

        ViewModel vm = controller.process(req, res);

        forward(req, res, vm);

    }

    private void forward(HttpServletRequest req, HttpServletResponse res, ViewModel vm) throws ServletException, IOException {
        processAttributes(req, vm);
        req.getRequestDispatcher(vm.getView()).forward(req, res);
    }

    private void processAttributes(HttpServletRequest req, ViewModel vm) {
        if (vm.getArgumentsMap().isEmpty()) {
            return;
        }
/*
        vm.getArgumentsMap().entrySet().stream()
*/

    }
}

