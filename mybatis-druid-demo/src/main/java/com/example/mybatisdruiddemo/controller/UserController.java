package com.example.mybatisdruiddemo.controller;

import com.example.mybatisdruiddemo.model.User;
import com.example.mybatisdruiddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Gary
 * @className UserController
 * @description TODO
 * @date 2019-10-28 15:23
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAllUser")
    public void getAllUser(){
        List<User> users = userService.getAllUser();

        users.forEach(user -> System.out.println(user.getUsUsername()));

    }
}
