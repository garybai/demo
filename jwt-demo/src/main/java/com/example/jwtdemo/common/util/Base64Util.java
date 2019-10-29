package com.example.jwtdemo.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * @author Gary
 * @className Base64Util
 * @description TODO
 * @date 2019-09-08 13:45
 **/
@Slf4j
public class Base64Util {

    private static final String charset = "utf-8";

    /**
     * 解密
     *
     * @param data
     * @return
     */
    public static String decode(String data) {
        try {
            if (null == data) {
                return null;
            }

            return new String(Base64.decodeBase64(data.getBytes(charset)), charset);
        } catch (UnsupportedEncodingException e) {
            log.error(String.format("字符串：%s，解密异常", data), e);
        }

        return null;
    }

    /**
     * 加密
     *
     * @param data
     * @return
     */
    public static String encode(String data) {
        try {
            if (null == data) {
                return null;
            }
            return new String(Base64.encodeBase64(data.getBytes(charset)), charset);
        } catch (UnsupportedEncodingException e) {
            log.error(String.format("字符串：%s，加密异常", data), e);
        }

        return null;
    }
}
