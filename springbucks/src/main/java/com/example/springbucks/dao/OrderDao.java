package com.example.springbucks.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbucks.model.Coffee;
import com.example.springbucks.model.Order;
import com.example.springbucks.model.OrderState;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @author Gary
 *
 * @date 2019-04-14 17:43
 */
public interface OrderDao extends BaseMapper<Order> {

    int createOrderCoffee(@Param("id") Long id, List<Long> coffeeIds);

    boolean updateState(Order order, OrderState state);

    List<Coffee> findCoffeeListByOrderId(@Param("id") Long id);

}
