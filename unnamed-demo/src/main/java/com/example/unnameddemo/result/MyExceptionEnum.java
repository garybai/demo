package com.example.unnameddemo.result;

public enum MyExceptionEnum {

    // 数据操作错误定义
    SUCCESS("200", "请求成功!"),
    BODY_NOT_MATCH("400", "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401", "请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503", "服务器正忙，请稍后再试!"),
    REQUEST_METHOD_SUPPORT_ERROR("40001", "当前请求方法不支持"),
    REQUEST_TIMEOUT("40000", "请求超时");

    /**
     * 错误码
     */
    private String resultCode;

    /**
     * 错误描述
     */
    private String resultMsg;

    MyExceptionEnum(String resultCode, String resultMsg) {
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
