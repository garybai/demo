package com.example.codedesigndemo.pattern.adapter.ac;

/**
 * 中国交流电
 *
 * @author Gary
 * @date 2020/1/10 14:25
 * @since jdk1.8
 **/
public class ChineseAC implements AC {
    @Override
    public int outputAC() {
        return 220;
    }
}
