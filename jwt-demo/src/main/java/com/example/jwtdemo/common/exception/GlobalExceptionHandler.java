package com.example.jwtdemo.common.exception;


import com.example.jwtdemo.common.result.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Gary
 * @className GlobalExceptionHandler
 * @description TODO
 * @date 2019-07-26 14:46
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = UserLoginException.class)
    public ResultData myExceptionHandler(HttpServletRequest req, UserLoginException e) {
        log.error("发生业务异常！原因是：{}，  {}", req.getRequestURI(), e.getErrorMsg());
        return ResultData.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("未知异常！原因是: {}，  {}", req.getRequestURI(), e.getMessage());
        return ResultData.error(UserLoginExceptionEnum.INTERNAL_SERVER_ERROR);
    }

}
