package com.ra.service;

import com.ra.model.entity.User;

public interface UserSevice extends IGeneric<User,Integer> {

    User login(User user);

    Boolean register (User user);


}
