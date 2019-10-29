package com.example.dynamicdatasourcedemo.controller;

import com.example.dynamicdatasourcedemo.aop.DataSource;
import com.example.dynamicdatasourcedemo.model.User;
import com.example.dynamicdatasourcedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @DataSource(value = "dsOne")
    @RequestMapping(value = "/getAllUser1")
    public void getAllUser1(){

        List<User> users = userService.getAllUser();

        users.forEach(user -> System.out.println(user.getUsUsername()));

    }

    @DataSource(value = "dsTwo")
    @RequestMapping(value = "/getAllUser2")
    public void getAllUser2(){

        List<User> users = userService.getAllUser();

        users.forEach(user -> System.out.println(user.getUsUsername()));

    }

    @DataSource(value = "dsOne")
    @Transactional
    @RequestMapping(value = "/insertUser1", method = RequestMethod.POST)
    public Integer insertUser1(@RequestParam("username") String username, @RequestParam("password") String password,
                              @RequestParam("isForbidden") Integer isForbidden) {
        int i = userService.insertUser(username, password, isForbidden);
        return i;
    }

    @DataSource(value = "dsTwo")
    @Transactional
    @RequestMapping(value = "/insertUser2", method = RequestMethod.POST)
    public Integer insertUser2(@RequestParam("username") String username, @RequestParam("password") String password,
                              @RequestParam("isForbidden") Integer isForbidden) {
        int i = userService.insertUser(username, password, isForbidden);
        return i;
    }
}
