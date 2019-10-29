package com.example.jwtdemo.common.exception;

public enum UserLoginExceptionEnum {

    // 返回Message
    SUCCESS("2000", "操作成功！"),
    USERNAME_PASSWORD_WRONG("4000", "用户名密码错误！"),
    USERNAME_NOT_EXIST("4001", "用户名不存在！"),
    USERNAME_NULL("4002", "用户名为空！"),
    TOKEN_EXPIRED("4003","token已过期"),
    TOKEN_NOT_EXIST("4004","token不存在"),
    USERNAME_FORBIDDEN("4005","用户已被禁！"),
    INTERNAL_SERVER_ERROR("5000", "服务器内部错误！");

    /**
     * 错误码
     */
    private String resultCode;

    /**
     * 错误描述
     */
    private String resultMsg;

    UserLoginExceptionEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }
}
