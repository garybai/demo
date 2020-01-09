package com.example.springsecuritywebfluxdemo.service.impl;

import com.example.springsecuritywebfluxdemo.service.IHelloService;

/**
 * HelloService熔断
 *
 * @author Gary
 * @date 2019/12/5 10:22
 * @since jdk1.8
 **/
public class HelloServiceFallback implements IHelloService {

    private Throwable throwable;

    public HelloServiceFallback(Throwable throwable){
        this.throwable = throwable;
    }
    /**
     * 测试接口
     *
     * @param name :
     * @return java.lang.String
     * @author: Gary
     * @date: 2019/12/3 17:00
     */
    @Override
    public String hello(String name) {
        return "hello " + name + ", this is snow-webbase! " + throwable.getMessage();
    }

    @Override
    public String test() {
        return "服务异常";
    }
}
