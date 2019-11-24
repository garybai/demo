package com.example.springsecuritydynamicdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gary
 * @className HelloController
 * @description TODO
 * @date 2019/11/23 12:16
 **/
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping(value = "/dba/hello")
    public String dba(){
        return "hello dba";
    }

    @GetMapping(value = "/admin/hello")
    public String admin(){
        return "hello admin";
    }

    @GetMapping(value = "/user/hello")
    public String user(){
        return "hello user";
    }
}
