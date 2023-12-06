package com.ra.service;

import com.ra.model.dao.UserDAO;
import com.ra.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserSevice {
   @Autowired
   UserDAO userDAO;
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Boolean create(User user) {
        return null;
    }

    @Override
    public Boolean update(User user, Integer integer) {
        return null;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }


    @Override
    public User login(User user) {
        return userDAO.login(user);
    }

    @Override
    public Boolean register(User user) {
        return userDAO.register(user);
    }
}
