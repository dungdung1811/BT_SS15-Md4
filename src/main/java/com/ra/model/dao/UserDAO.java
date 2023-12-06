package com.ra.model.dao;

import com.ra.model.entity.User;

public interface UserDAO extends IGeneric<User,Integer>{
    User login(User user);
    Boolean register (User user);
}
