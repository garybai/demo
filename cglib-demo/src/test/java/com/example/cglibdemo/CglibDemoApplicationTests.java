package com.example.cglibdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CglibDemoApplicationTests {

    @Test
    void contextLoads() {
        CglibProxy cglibProxy = new CglibProxy();
        HelloService helloService = (HelloService) cglibProxy.newProxyInstance(HelloService.class);
        helloService.sayHello("Gary");
        helloService.sayGoodBye("Gary");
    }

}
