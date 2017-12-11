package com.akhambir.dao;

import com.akhambir.model.User;

import java.sql.Connection;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    public User create(User user) {
        return null;
    }

    public User findById(Long id) {
        return null;
    }

    public User update(User user) {
        return super.update(user);
    }

    public User delete(User user) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
