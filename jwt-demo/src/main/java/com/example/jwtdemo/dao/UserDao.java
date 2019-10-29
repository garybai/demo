package com.example.jwtdemo.dao;

import com.example.jwtdemo.pojo.UserDO;
import com.example.jwtdemo.pojo.UsernameAndPasswordDTO;

public interface UserDao {

    Integer checkUserIsExist(String username);

    Integer checkUserIsForbidden(String username);

    Integer checkUsernameAndPassword(UsernameAndPasswordDTO usernameAndPasswordDTO);

    UserDO findUserByUsername(String username);

}
