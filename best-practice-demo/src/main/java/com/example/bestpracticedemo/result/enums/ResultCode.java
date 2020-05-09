package com.example.bestpracticedemo.result.enums;

import lombok.Getter;

/**
 * 响应码枚举类
 *
 * @author Gary
 * @date 2020/5/9 15:16
 **/
@Getter
public enum  ResultCode {

    SUCCESS(1000, "操作成功"),
    FAILED(1001, "操作失败"),
    VALIDATE_FAILED(1002, "参数校验失败"),
    ERROR(5000, "未知错误");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
