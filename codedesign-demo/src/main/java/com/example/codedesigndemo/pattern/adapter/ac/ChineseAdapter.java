package com.example.codedesigndemo.pattern.adapter.ac;

/**
 * 中国电源适配器
 *
 * @author Gary
 * @date 2020/1/10 14:31
 * @since jdk1.8
 **/
public class ChineseAdapter implements DC5Adapter {
    private static final int VOLTAGE = 220;
    @Override
    public boolean support(AC ac) {
        return VOLTAGE == ac.outputAC();
    }

    @Override
    public int outputDC5(AC ac) {
        int input = ac.outputAC();
        int output = input / 44;
        System.out.println("使用中国适配器，输入：" + input + "，输出：" + output);
        return output;
    }
}
