package com.example.bestpracticedemo.result.controller;

import com.example.bestpracticedemo.result.annotation.NotResponseBody;
import com.example.bestpracticedemo.result.entity.User;
import com.example.bestpracticedemo.result.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户Controller
 *
 * @author Gary
 * @date 2020/5/9 15:42
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public Boolean addUser(@Valid @RequestBody User user) {
        String s = userService.addUser(user);
        return true;
    }

    @GetMapping("/getUser1")
    @NotResponseBody
    public User getUser1() {
        User user = new User();
        user.setId(1L);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");
        return user;
    }

    @GetMapping("/getUser2")
    public User getUser2() {
        User user = new User();
        user.setId(1L);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");
        return user;
    }
}
