package com.yangchd.week09.homework03.server.config;

import com.yangchd.week09.homework03.api.service.OrderService;
import com.yangchd.week09.homework03.api.service.UserService;
import com.yangchd.week09.homework03.server.service.impl.OrderServiceImpl;
import com.yangchd.week09.homework03.server.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean("com.example.demo.service.UserService")
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean("com.example.demo.service.OrderService")
    public OrderService orderService() {
        return new OrderServiceImpl();
    }
}
