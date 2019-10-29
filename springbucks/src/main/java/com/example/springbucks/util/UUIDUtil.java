package com.example.springbucks.util;

import java.util.UUID;

/**
 * @author Gary
 * @className UUIDUtil
 * @description TODO
 * @date 2019-05-11 23:32
 **/
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString()
                .replace("-", "").toLowerCase();
    }
}
