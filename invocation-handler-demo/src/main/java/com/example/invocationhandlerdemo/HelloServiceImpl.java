package com.example.invocationhandlerdemo;

import org.springframework.stereotype.Service;

/**
 * @author Gary
 * @className HelloServiceImpl
 * @description TODO
 * @date 2019-11-07 10:15
 **/
@Service(value = "helloService")
public class HelloServiceImpl implements IHelloService {

    @Override
    public void sayHello(String name) {
//        System.out.println("我来了");
        System.out.println("Hello " + name);
    }

    @Override
    public void sayGoodBye(String name) {
//        System.out.println("我走了");
        System.out.println(name + " goodbye");
    }
}
