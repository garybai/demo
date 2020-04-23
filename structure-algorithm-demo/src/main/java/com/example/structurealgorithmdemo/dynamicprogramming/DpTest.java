package com.example.structurealgorithmdemo.dynamicprogramming;

import cn.hutool.core.util.NumberUtil;

/**
 * 动态规划
 *
 * @author Gary
 * @date 2020/4/15 23:54
 **/
public class DpTest {

    public static void main(String[] args) {

        // 找到不相邻的数和的最大值
        int[] arr = {1, 2, 4, 1, 7, 8, 3};
        System.out.println(recOpt(arr, arr.length - 1));
        System.out.println(dpOpt(arr));

    }

    private static Integer dpOpt(int[] arr) {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = NumberUtil.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int a = opt[i - 2] + arr[i];
            int b = opt[i - 1];
            opt[i] = NumberUtil.max(a, b);
        }
        return opt[arr.length - 1];
    }

    private static Integer recOpt(int[] arr, int n) {
        if (n == 0) {
            return arr[0];
        }
        if (n == 1) {
            return NumberUtil.max(arr[0], arr[1]);
        }
        int a = recOpt(arr, n - 2) + arr[n];
        int b = recOpt(arr, n - 1);
        return NumberUtil.max(a, b);
    }


}
