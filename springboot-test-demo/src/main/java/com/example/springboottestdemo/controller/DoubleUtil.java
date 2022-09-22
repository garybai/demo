package com.example.springboottestdemo.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName:
 * @Description:double工具类
 * @Author huxiaosan
 * @DateTime
 */
public class DoubleUtil {
    //保留一位小数，四舍五入
    public static double formatDouble1(double before){
       return new BigDecimal(before).setScale(1, RoundingMode.UP).doubleValue();
    }
    //保留两位小数，四舍五入
    public static double formatDouble2(double before){
       return new BigDecimal(before).setScale(2, RoundingMode.UP).doubleValue();
    }
}
