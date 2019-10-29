package com.example.springbootstarterdemo.service;

/**
 * @author Gary
 * @className HelloService
 * @description TODO
 * @date 2019-10-22 16:44
 **/
public class HelloService {

    private String msg;
    private String name;
    public String sayHello() {
        return name + " say " + msg + " !";
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
