package com.example.bestpracticedemo.design.check;

/**
 * 状态枚举类
 *
 * @author: Gary
 * @date: 2020/3/31 11:20
 */
public enum StateEnum {

    /**
     * 一审待审
     */
    FIRST_WAIT(0, "FIRST_WAIT"),

    /**
     * 二审待审
     */
    SECOND_WAIT(1, "SECOND_WAIT"),

    /**
     * 一审驳回
     */
    FIRST_REJECT(10, "FIRST_REJECT"),

    /**
     * 二审通过，三审待审
     */
    THIRD_WAIT(2, "THIRD_WAIT"),

    /**
     * 二审驳回
     */
    SECOND_REJECT(20, "SECOND_REJECT"),

    /**
     * 三审通过，可分发
     */
    PUBLISHABLE(3, "PUBLISHABLE"),

    /**
     * 三审驳回
     */
    THIRD_REJECT(30, "THIRD_REJECT");

    private Integer key;
    private String value;

    StateEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString(){
        return key + "\t" + value;
    }

}
