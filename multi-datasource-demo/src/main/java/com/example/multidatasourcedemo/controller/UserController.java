package com.example.multidatasourcedemo.controller;

import com.example.multidatasourcedemo.model.User;
import com.example.multidatasourcedemo.service.UserService;
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

    @RequestMapping(value = "/getAllUser")
    public void getAllUser() {
        List<User> users2 = userService.getAllUser2();

        users2.forEach(user -> System.out.println(user.getUsUsername()));
        List<User> users1 = userService.getAllUser1();

        users1.forEach(user -> System.out.println(user.getUsUsername()));

    }

    @Transactional
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public Integer insertUser(@RequestParam("username") String username, @RequestParam("password") String password,
                              @RequestParam("isForbidden") Integer isForbidden) {
        int i = userService.insertUser1(username, password, isForbidden);
        int j = userService.insertUser2(username, password, isForbidden);
        return i + j ;
    }
}
