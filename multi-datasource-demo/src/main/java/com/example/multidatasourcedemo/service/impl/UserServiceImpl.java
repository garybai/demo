package com.example.multidatasourcedemo.service.impl;

import com.example.multidatasourcedemo.mapper.mapper1.UserMapper1;
import com.example.multidatasourcedemo.mapper.mapper2.UserMapper2;
import com.example.multidatasourcedemo.model.User;
import com.example.multidatasourcedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gary
 * @className UserServiceImpl
 * @description TODO
 * @date 2019-10-28 15:21
 **/
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper1 userMapper1;

    @Autowired
    private UserMapper2 userMapper2;

    @Override
    public List<User> getAllUser1() {
        return userMapper1.getAllUser();
    }

    @Override
    public List<User> getAllUser2() {
        return userMapper2.getAllUser();
    }
}
