package com.example.springbucks.controller;

import com.example.springbucks.model.Coffee;
import com.example.springbucks.model.Order;
import com.example.springbucks.model.OrderState;
import com.example.springbucks.model.vo.OrderVO;
import com.example.springbucks.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Gary
 * @className OrderController
 * @description TODO
 * @date 2019-04-14 18:44
 **/

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/test")
    public void test() {
        System.out.println(OrderState.INIT.getValue());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Order save(@RequestParam String customer,
                      @RequestParam List<Long> coffeeIds) {
        return orderService.createOrder(customer, coffeeIds);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public OrderVO findOrderDetailById(@RequestParam Long id) {
        Order order = orderService.getById(id);
        List<Coffee> coffees = orderService.findCoffeeListByOrderId(id);
        OrderVO orderVO = new OrderVO(order, coffees);
        log.info("result: {}", orderVO);
        return orderVO;
    }
}
