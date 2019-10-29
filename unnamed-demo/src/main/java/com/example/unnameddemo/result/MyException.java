package com.example.unnameddemo.result;

import lombok.Data;

/**
 * @author Gary
 * @className MyException
 * @description TODO
 * @date 2019-07-26 14:37
 **/
@Data
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public MyException() {
        super();
    }

    public MyException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public MyException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public MyException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public MyException(MyExceptionEnum myExceptionEnum) {
        super(myExceptionEnum.getResultMsg());
        this.errorCode = myExceptionEnum.getResultCode();
        this.errorMsg = myExceptionEnum.getResultMsg();
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
