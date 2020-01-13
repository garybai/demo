package com.example.codedesigndemo.pattern.adapter.ac;

/**
 * 日本电源适配器
 *
 * @author Gary
 * @date 2020/1/10 14:35
 * @since jdk1.8
 **/
public class JapaneseAdapter implements DC5Adapter {
    private static final int VOLTAGE= 110;
    @Override
    public boolean support(AC ac) {
        return VOLTAGE == ac.outputAC();
    }

    @Override
    public int outputDC5(AC ac) {
        int input = ac.outputAC();
        int output = input / 22;
        System.out.println("使用日本适配器，输入：" + input + "，输出：" + output);
        return output;
    }
}
