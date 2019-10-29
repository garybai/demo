package com.example.springbucks.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbucks.dao.OrderDao;
import com.example.springbucks.model.Coffee;
import com.example.springbucks.model.Order;
import com.example.springbucks.model.OrderState;
import com.example.springbucks.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单接口
 *
 * @author Gary
 * @className OrderServiceImpl
 * @description TODO
 * @date 2019-04-14 18:14
 **/
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Order createOrder(String customer, List<Long> coffeeIds) {
        Order order = new Order();
        order.setCustomer(customer).setState(OrderState.INIT.getValue());
        baseMapper.insert(order);
        orderDao.createOrderCoffee(order.getId(), coffeeIds);
        return baseMapper.selectById(order.getId());
    }

    @Override
    public boolean updateState(Order order, OrderState state) {
        return orderDao.updateState(order, state);
    }

    @Override
    public List<Coffee> findCoffeeListByOrderId(Long id) {
        return orderDao.findCoffeeListByOrderId(id);
    }
}
