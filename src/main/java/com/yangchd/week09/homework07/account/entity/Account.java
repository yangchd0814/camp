package com.yangchd.week09.homework07.account.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Account implements Serializable {

    private Long id;

    private String name;

    private Long cny_wallet;

    private Long us_wallet;
}
