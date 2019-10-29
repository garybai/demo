package com.example.rabbitmqproducerdemo.controller;

import com.example.rabbitmqproducerdemo.mq.MqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gary
 * @className TestController
 * @description TODO
 * @date 2019-06-29 12:41
 **/
@RestController
public class TestController {

    @Autowired
    private MqSender mqSender;

    @GetMapping(value = "testMq")
    public void testMq(){
        for (int i = 0; i < 10; i++) {
            mqSender.send("I'm message " + i);
            try {
                Thread.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //mqSender.sendB("queueB message" + i);
        }
    }
}
