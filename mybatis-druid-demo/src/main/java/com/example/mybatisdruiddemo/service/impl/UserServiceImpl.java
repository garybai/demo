package com.example.mybatisdruiddemo.service.impl;

import com.example.mybatisdruiddemo.mapper.UserMapper;
import com.example.mybatisdruiddemo.model.User;
import com.example.mybatisdruiddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gary
 * @className UserServiceImpl
 * @description TODO
 * @date 2019-10-28 17:24
 **/
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
}
