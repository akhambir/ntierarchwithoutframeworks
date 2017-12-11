package com.akhambir;

import com.akhambir.controller.CreateUserController;
import com.akhambir.dao.UserDaoImpl;
import com.akhambir.service.UserServiceImpl;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        CreateUserController controller2 = (CreateUserController) Function.identity()
                .compose(CreateUserController::new)
                .compose(UserServiceImpl::new)
                .compose(UserDaoImpl::new)
                .apply(Factory.getConnection());

    }
}
