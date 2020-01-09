package com.example.springsecuritywebfluxdemo.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 统一返回值类
 *
 * @author Gary
 * @date 2019/12/13 11:58
 * @since jdk1.8
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SnowResult<T> implements Serializable {
    private static final long serialVersionUID = 5428550717297353655L;

    /**
     * 状态。成功：ok；失败：error
     */
    private String status;

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息：如失败原因等
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 自定义返回
     * @param status:
     * @param code:
     * @param message:
     * @param data:
     * @return com.guwukeji.snowcommon.result.SnowResult
     * @author: Gary
     * @date: 2019/12/13 14:30
     */
    public static <T> SnowResult of(String status, Integer code, String message, T data) {
        SnowResult<T> result = new SnowResult<>();
        result.setStatus(status).setCode(code).setMessage(message).setData(data);
        return result;
    }

    /**
     * 成功返回
     * @param data:
     * @return com.guwukeji.snowcommon.result.SnowResult
     * @author: Gary
     * @date: 2019/12/13 14:30
     */
    public static <T> SnowResult ofSuccess(T data) {
        return of("ok", SnowResultEnum.SUCCESS.getCode(), SnowResultEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 失败返回
     * @param :
     * @return com.guwukeji.snowcommon.result.SnowResult
     * @author: Gary
     * @date: 2019/12/13 14:30
     */
    public static <T> SnowResult ofError() {
        return of("error", SnowResultEnum.ERROR.getCode(), SnowResultEnum.ERROR.getMessage(), null);
    }

    /**
     * 自定义失败返回
     * @param code:
     * @param message:
     * @return com.guwukeji.snowcommon.result.SnowResult
     * @author: Gary
     * @date: 2019/12/13 14:41
     */
    public static <T> SnowResult ofError(Integer code, String message) {
        return of("error", code, message, null);
    }

    public static <T> SnowResult ofError(SnowResultEnum resultEnum) {
        return of("error", resultEnum.getCode(), resultEnum.getMessage(), null);
    }

//    public static <T extends SnowException> SnowResult ofException(T t) {
//        return of("error", t.getErrCode(), t.getErrMessage(), null);
//    }

}
