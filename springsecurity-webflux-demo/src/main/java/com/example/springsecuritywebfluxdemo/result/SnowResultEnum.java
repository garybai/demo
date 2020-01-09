package com.example.springsecuritywebfluxdemo.result;

/**
 * 返回值枚举类
 * @author Gary
 */
public enum SnowResultEnum {

    /**
     * 请求
     */
    SUCCESS(200, "请求成功"),
    ERROR(500, "服务器内部错误"),
    UNAUTHORIZED(501, "未登陆"),
    BODY_NOT_MATCH(400, "请求的数据格式不符"),
    TOO_MANY_REQUESTS(444, "请求过于频繁"),
    ACCESS_DENIED(403, "无权限"),
    USERNAME_PASSWORD_ERROR(410, "用户名或密码错误"),
    USER_DISABLED(411, "用户不可用"),
    USERNAME_NOT_FOUND(412, "用户名不存在"),
    SERVER_BUSY(503, "服务器繁忙");

    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;

    SnowResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
