package com.ra.service;

import com.ra.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserSevice {

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
    public Boolean login(User user) {
        if(user.getEmail().equals("dung@gmail.com")&& user.getPassword().equals("123")){
            return true;
        }
        return false;
    }
}
