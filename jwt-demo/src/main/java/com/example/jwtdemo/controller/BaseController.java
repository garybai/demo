package com.example.jwtdemo.controller;

import com.example.jwtdemo.common.util.JwtTokenUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Gary
 * @className BaseController
 * @description TODO
 * @date 2019-09-08 00:57
 **/
public class BaseController {

    /**
     * 根据token获取用户ID
     *
     * @param request
     * @return
     */
    public String getUserId(HttpServletRequest request) {

        // 取得token
        String tokenHeader = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        tokenHeader = tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX, "");
        return JwtTokenUtil.getObjectId(tokenHeader);
    }

}
