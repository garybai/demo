package com.example.unnameddemo.result;

import lombok.Data;

/**
 * @author Gary
 * @className ResultData
 * @description TODO
 * @date 2019-07-26 11:58
 **/
@Data
public class ResultData<T> {

    private boolean success = true;

    private String code = "0";

    private String message = null;

    private T data = null;

    public ResultData() {

    }

    // 成功时
    public static ResultData ok() {
        return ok(null);
    }

    public static <T> ResultData<T> ok(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(MyExceptionEnum.SUCCESS.getResultCode());
        resultData.setMessage(MyExceptionEnum.SUCCESS.getResultMsg());
        resultData.setData(data);
        return resultData;
    }

    // 异常时
    public static <T> ResultData<T> error(String code, String msg) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setSuccess(false);
        resultData.setCode(code);
        resultData.setMessage(msg);
        resultData.setData(null);
        return resultData;
    }

    public static <T> ResultData<T> error(MyExceptionEnum myExceptionEnum) {
        return error(myExceptionEnum.getResultCode(), myExceptionEnum.getResultMsg());
    }


}
