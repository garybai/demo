package com.example.jwtdemo.controller;

import com.example.jwtdemo.common.exception.UserLoginExceptionEnum;
import com.example.jwtdemo.common.result.ResultData;
import com.example.jwtdemo.common.util.JwtTokenUtil;
import com.example.jwtdemo.pojo.UserDO;
import com.example.jwtdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gary
 * @className AdminUserController
 * @description TODO
 * @date 2019-09-08 09:57
 **/
@RestController
@RequestMapping(value = "user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultData<UserDO> login(HttpServletResponse response, String username, String password) {

        // 判断用户是否存在
        boolean isExist = userService.checkUserIsExist(username);
        if (!isExist) {
            return ResultData.error(UserLoginExceptionEnum.USERNAME_NOT_EXIST);
        }

        // 判断用户是否被禁
        boolean isForbidden = userService.checkUserIsForbidden(username);
        if (isForbidden) {
            return ResultData.error(UserLoginExceptionEnum.USERNAME_FORBIDDEN);
        }

        // 判断用户名密码是否正确
        boolean isValid = userService.checkUsernameAndPassword(username, password);
        if (!isValid) {
            return ResultData.error(UserLoginExceptionEnum.USERNAME_PASSWORD_WRONG);
        }

        UserDO userDO = userService.findUserByUsername(username);
        String token = JwtTokenUtil.createToken(userDO.getId().toString(), userDO.getUsername(), false);
        //放到响应头部
        response.setHeader(JwtTokenUtil.TOKEN_HEADER, JwtTokenUtil.TOKEN_PREFIX + token);
        return ResultData.ok(userDO);
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ResultData<String> logout(HttpServletRequest request) {

        String userId = getUserId(request);
        return ResultData.ok("退出成功");
    }


}
