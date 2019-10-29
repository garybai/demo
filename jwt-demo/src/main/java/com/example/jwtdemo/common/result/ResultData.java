package com.example.jwtdemo.common.result;

import com.example.jwtdemo.common.exception.UserLoginExceptionEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Gary
 * @className ResultData
 * @description TODO
 * @date 2019-09-08 00:36
 **/
@Data
public class ResultData<T> implements Serializable {

    private boolean success = true;

    private String code = "0";

    private String message = null;

    private T data = null;

    public ResultData() {

    }

    /**
     * TODO
     *
     * @author Gary
     * @param
     *
     * @return com.example.jwtdemo.common.result.ResultData
     * @date 2019-09-08 00:38
     */
    public static ResultData ok() {
        return ok(null);
    }

    /**
     * TODO
     *
     * @author Gary
     * @param data
     *
     * @return com.example.jwtdemo.common.result.ResultData<T>
     * @date 2019-09-08 00:38
     */
    public static <T> ResultData<T> ok(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(UserLoginExceptionEnum.SUCCESS.getResultCode());
        resultData.setMessage(UserLoginExceptionEnum.SUCCESS.getResultMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * TODO
     *
     * @author Gary
     * @param code
     * @param msg
     *
     * @return com.example.jwtdemo.common.result.ResultData<T>
     * @date 2019-09-08 00:38
     */
    public static <T> ResultData<T> error(String code, String msg) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setSuccess(false);
        resultData.setCode(code);
        resultData.setMessage(msg);
        return resultData;
    }

    public static <T> ResultData<T> error(UserLoginExceptionEnum userLoginExceptionEnum) {
        return error(userLoginExceptionEnum.getResultCode(), userLoginExceptionEnum.getResultMsg());
    }

}
