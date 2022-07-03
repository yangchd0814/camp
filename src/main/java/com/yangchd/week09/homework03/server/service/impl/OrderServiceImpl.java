package com.yangchd.week09.homework03.server.service.impl;

import com.yangchd.week09.homework03.api.model.Order;
import com.yangchd.week09.homework03.api.service.OrderService;
import com.yangchd.week09.homework03.core.exception.CustomException;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order findById(Integer id) {
        return new Order(1, "RPC", 1);
    }

    @Override
    public Order findError() {
        throw new CustomException("Custom exception");
    }
}
