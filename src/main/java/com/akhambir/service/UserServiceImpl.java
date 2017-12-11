package com.akhambir.service;

import com.akhambir.dao.UserDao;
import com.akhambir.model.User;

import java.time.LocalTime;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public Optional<String> checkUser(String email, String password) {
        User user = userDao.findByEmail(email);

        if (user.getPassword().equals(password)) { //TODO check password using hashing
            String token = LocalTime.now().toString();
            user.setToken(token);
            userDao.update(user);
            return Optional.of(token);
        }

        return Optional.empty();
    }
}
