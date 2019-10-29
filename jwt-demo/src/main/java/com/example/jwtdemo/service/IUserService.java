package com.example.jwtdemo.service;

import com.example.jwtdemo.pojo.UserDO;

public interface IUserService {

    Boolean checkUserIsExist(String username);

    Boolean checkUserIsForbidden(String username);

    Boolean checkUsernameAndPassword(String username, String password);

    UserDO findUserByUsername(String username);

}
