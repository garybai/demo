package com.example.springboottestdemo.controller;

import com.example.springboottestdemo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ceshi controller
 *
 * @author Gary
 * @date 2020/5/6 15:41
 **/
@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    @RequestMapping("/hello")
    public String hello(){
        return service.hello();
    }

    @RequestMapping("/test")
    public String test(@RequestParam("id") String id){
        return id;
    }

}
