package com.example.springsecuritywebfluxdemo.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Gary
 */
public interface IHelloService {

    /**
     * 测试接口
     *
     * @param name:
     * @return java.lang.String
     * @author: Gary
     * @date: 2019/12/3 17:00
     */
    @PostMapping("/hello")
    String hello(@RequestParam("name") String name);

    @GetMapping("/test")
    String test();

}
