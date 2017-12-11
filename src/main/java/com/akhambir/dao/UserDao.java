package com.akhambir.dao;

import com.akhambir.model.User;

public interface UserDao extends GenericDao<User> {


    User findByEmail(String email);
}
