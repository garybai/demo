package com.example.jwtdemo.common.exception;

import lombok.Data;

/**
 * @author Gary
 * @className UserLoginException
 * @description TODO
 * @date 2019-09-08 00:17
 **/
@Data
public class UserLoginException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     *
     */
    private String errorCode;

    /**
     * 错误信息
     *
     */
    private String errorMsg;

    public UserLoginException() {
        super();
    }

    public UserLoginException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public UserLoginException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public UserLoginException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public UserLoginException(UserLoginExceptionEnum userLoginExceptionEnum) {
        super(userLoginExceptionEnum.getResultMsg());
        this.errorCode = userLoginExceptionEnum.getResultCode();
        this.errorMsg = userLoginExceptionEnum.getResultMsg();
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
