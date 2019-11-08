package com.example.invocationhandlerdemo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Gary
 * @className StaticProxy
 * @description TODO
 * @date 2019-11-07 10:22
 **/
@Service(value = "staticProxy")
public class StaticProxy implements IHelloService {

    @Resource
    private IHelloService helloService;

    @Override
    public void sayHello(String name) {
        System.out.println("我来了");
        helloService.sayHello(name);
    }

    @Override
    public void sayGoodBye(String name) {
        System.out.println("我走了");
        helloService.sayGoodBye(name);
    }
}
