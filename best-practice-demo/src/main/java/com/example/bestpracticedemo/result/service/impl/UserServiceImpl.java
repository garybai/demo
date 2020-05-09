package com.example.bestpracticedemo.result.service.impl;

import com.example.bestpracticedemo.result.entity.User;
import com.example.bestpracticedemo.result.exception.APIException;
import com.example.bestpracticedemo.result.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户Service实现
 *
 * @author Gary
 * @date 2020/5/9 15:45
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String addUser(User user) {
//        System.out.println(1/0);
        throw new APIException(10001, "aaaaa");
//        return "success";
    }
}
