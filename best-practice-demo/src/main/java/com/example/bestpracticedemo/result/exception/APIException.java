package com.example.bestpracticedemo.result.exception;

import lombok.Getter;

/**
 * 自定义异常
 *
 * @author Gary
 * @date 2020/5/9 15:07
 **/
@Getter
public class APIException extends RuntimeException {

    private Integer code;
    private String message;

    public APIException() {
        this(10000, "接口错误");
    }

    public APIException(String message) {
        this(10000, message);
    }

    public APIException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
