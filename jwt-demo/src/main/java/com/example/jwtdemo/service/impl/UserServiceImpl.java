package com.example.jwtdemo.service.impl;

import com.example.jwtdemo.dao.UserDao;
import com.example.jwtdemo.pojo.UserDO;
import com.example.jwtdemo.pojo.UsernameAndPasswordDTO;
import com.example.jwtdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gary
 * @className UserServiceImpl
 * @description TODO
 * @date 2019-09-08 10:19
 **/
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Boolean checkUserIsExist(String username) {
        int count = userDao.checkUserIsExist(username);
        return count > 0;
    }

    @Override
    public Boolean checkUserIsForbidden(String username) {
        int forbidden = userDao.checkUserIsForbidden(username);
        return forbidden == 1;
    }

    @Override
    public Boolean checkUsernameAndPassword(String username, String password) {
        UsernameAndPasswordDTO dto = new UsernameAndPasswordDTO(username, password);
        return userDao.checkUsernameAndPassword(dto) > 0;
    }

    @Override
    public UserDO findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

}
