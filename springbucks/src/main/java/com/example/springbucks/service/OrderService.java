package com.example.springbucks.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbucks.model.Coffee;
import com.example.springbucks.model.Order;
import com.example.springbucks.model.OrderState;

import java.util.List;

public interface OrderService extends IService<Order> {

    Order createOrder(String customer, List<Long> coffeeIds);

    boolean updateState(Order order, OrderState state);

    List<Coffee> findCoffeeListByOrderId(Long id);
}
