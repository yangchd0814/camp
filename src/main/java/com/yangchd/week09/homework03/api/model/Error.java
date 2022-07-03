package com.yangchd.week09.homework03.api.model;

public class Error {

    private Integer status;
    private String message;

    public Error(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
