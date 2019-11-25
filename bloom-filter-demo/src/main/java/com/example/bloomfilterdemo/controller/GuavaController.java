package com.example.bloomfilterdemo.controller;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gary
 * @className BloomFilter
 * @description TODO
 * @date 2019/11/21 17:54
 **/
@RestController
public class GuavaController {

    private static int size = 1000000;//预计要插入多少数据

    private static double fpp = 0.01;//期望的误判率

    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, fpp);

    public static void main(String[] args) {
        //插入数据
        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }
        int count = 0;
        for (int i = 1000000; i < 2000000; i++) {
            if (bloomFilter.mightContain(i)) {
                count++;
                System.out.println(i + "误判了");
            }
        }
        System.out.println("总共的误判数:" + count);
    }

}
