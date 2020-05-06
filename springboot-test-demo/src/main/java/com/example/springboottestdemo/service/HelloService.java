package com.example.springboottestdemo.service;

import org.springframework.stereotype.Service;

/**
 * hello service
 *
 * @author Gary
 * @date 2020/5/6 15:42
 **/
@Service
public class HelloService {

    public String hello() {
        return "hello";
    }

}
