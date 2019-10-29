package com.example.dynamicdatasourcedemo.service.impl;

import com.example.dynamicdatasourcedemo.mapper.UserMapper;
import com.example.dynamicdatasourcedemo.model.User;
import com.example.dynamicdatasourcedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private UserMapper userMapper;


    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    @Transactional(transactionManager = "transactionManager")
    public int insertUser(String username, String password, Integer isForbidden) {
        int insert = userMapper.insertUser(username, password, isForbidden);
        int i = 1 / isForbidden;
        return insert;
    }


}
