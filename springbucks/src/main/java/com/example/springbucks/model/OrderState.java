package com.example.springbucks.model;

/**
 * 订单状态枚举
 *
 * @author Gary
 * @date 2019-04-13 19:12
 */
public enum OrderState {

    INIT(0),
    PAID(1),
    BREWING(2),
    BREWED(3),
    TAKEN(4),
    CANCELLED(5);

    private int value;

    OrderState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
