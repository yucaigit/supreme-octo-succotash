package com.etc.demo.service.impl;

import com.etc.demo.dao.OrderDao;
import com.etc.demo.entity.Order;
import com.etc.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public List<Order> getAll(Integer uid) {
        List<Order> list = orderDao.findAll(uid);
        return list;
    }

    @Override
    public Boolean deleteById(Integer orderId) {
        int i = orderDao.deleteById(orderId);
        if (i >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateOrderState(Integer oId) {
        return orderDao.updateOrderState(oId);
    }

}
