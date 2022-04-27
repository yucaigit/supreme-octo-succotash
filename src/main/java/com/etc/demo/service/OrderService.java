package com.etc.demo.service;


import com.etc.demo.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll(Integer uid);

    Boolean deleteById(Integer orderId);

    Boolean updateOrderState(Integer oId);
}
