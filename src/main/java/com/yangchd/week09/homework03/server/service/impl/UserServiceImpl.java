package com.yangchd.week09.homework03.server.service.impl;

import com.yangchd.week09.homework03.api.model.User;
import com.yangchd.week09.homework03.api.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User findById(Integer id) {
        return new User(id, "RPC");
    }
}
