package com.yangchd.week09.homework03.api.service;


import com.yangchd.week09.homework03.api.model.Order;

public interface OrderService {

    /**
     * find by id
     * @param id id
     * @return order
     */
    Order findById(Integer id);

    /**
     * return exception
     * @return exception
     */
    Order findError();
}
