package com.yangchd.week09.homework03.api.service;

import com.yangchd.week09.homework03.api.model.User;

public interface UserService {

    /**
     * find by id
     * @param id id
     * @return user
     */
    User findById(Integer id);
}
