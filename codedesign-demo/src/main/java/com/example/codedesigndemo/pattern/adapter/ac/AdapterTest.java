package com.example.codedesigndemo.pattern.adapter.ac;

import java.util.ArrayList;
import java.util.List;

/**
 * 电源适配器测试
 *
 * @author Gary
 * @date 2020/1/10 14:37
 * @since jdk1.8
 **/
public class AdapterTest {
    private List<DC5Adapter> adapters = new ArrayList<>();
    public AdapterTest(){
        this.adapters.add(new ChineseAdapter());
        this.adapters.add(new JapaneseAdapter());
    }
    public DC5Adapter getAdapter(AC ac){
        DC5Adapter adapter = null;
        for (DC5Adapter ad : this.adapters){
            if (ad.support(ac)){
                adapter = ad;
                break;
            }
        }
        if (adapter ==null){
            throw new IllegalArgumentException("没有找到合适的变压器。");
        }
        return adapter;
    }
    public static void main(String[] args) {
        AdapterTest test = new AdapterTest();
        ChineseAC chineseAC = new ChineseAC();
        DC5Adapter adapter = test.getAdapter(chineseAC);
        adapter.outputDC5(chineseAC);
        JapaneseAC japaneseAC = new JapaneseAC();
        DC5Adapter adapter1 = test.getAdapter(japaneseAC);
        adapter1.outputDC5(japaneseAC);
    }
}
