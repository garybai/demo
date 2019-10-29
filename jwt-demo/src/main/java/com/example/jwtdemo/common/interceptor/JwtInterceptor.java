package com.example.jwtdemo.common.interceptor;

import com.example.jwtdemo.common.exception.UserLoginException;
import com.example.jwtdemo.common.exception.UserLoginExceptionEnum;
import com.example.jwtdemo.common.util.JwtTokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gary
 * @className JwtInterceptor
 * @description TODO
 * @date 2019-09-08 10:36
 **/
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        // 取得token
        String tokenHeader = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            throw new UserLoginException(UserLoginExceptionEnum.TOKEN_NOT_EXIST);
        }
        tokenHeader = tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX, "");
        // 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
        JwtTokenUtil.getTokenBody(tokenHeader);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }
}
