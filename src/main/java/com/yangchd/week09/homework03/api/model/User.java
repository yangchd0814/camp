package com.yangchd.week09.homework03.api.model;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
