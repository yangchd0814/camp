package com.yangchd.week05.homework02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanTest {

    @Bean
    public BeanTest newBeanTest() {
        return new BeanTest();
    }
}
