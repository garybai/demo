package com.example.codedesigndemo.pattern.adapter.ac;

/**
 * 日本交流电
 *
 * @author Gary
 * @date 2020/1/10 14:26
 * @since jdk1.8
 **/
public class JapaneseAC implements AC {
    @Override
    public int outputAC() {
        return 110;
    }
}
