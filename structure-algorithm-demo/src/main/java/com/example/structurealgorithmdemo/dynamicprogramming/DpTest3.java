package com.example.structurealgorithmdemo.dynamicprogramming;

import cn.hutool.core.util.NumberUtil;

/**
 * 动态规划
 *
 * @author Gary
 * @date 2020/4/15 23:54
 **/
public class DpTest3 {

    public static void main(String[] args) {
        // 0-1背包问题 knapsack
        // wArr是表示商品重量的数组  vArr是表示商品价值的数组
        // 这里前都补个0方便递归
        int[] wArr = {0, 2, 3, 4, 5, 9};
        int[] vArr = {0, 3, 4, 5, 8, 10};
        // 背包总容量
        int capacity = 20;

        System.out.println(knapsack(wArr, vArr, capacity));
        System.out.println(knapsack1(wArr, vArr, capacity));

    }

    private static Integer knapsack(int[] wArr, int[] vArr, int capacity) {
        int[][] b = new int[wArr.length][capacity + 1];
        // i循环商品下标，j循环背包容量
        for (int i = 1; i < wArr.length; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                // 如果容量不够装不下，商品下标减1
                if (j < wArr[i]) {
                    b[i][j] = b[i - 1][j];
                } else {
                    // 如果装第i件商品
                    int v1 = b[i - 1][j - wArr[i]] + vArr[i];
                    // 如果不装第i件商品
                    int v2 = b[i - 1][j];
                    // 取两者的最大值
                    b[i][j] = NumberUtil.max(v1, v2);
                }
            }
        }
        return b[wArr.length - 1][capacity];
    }

    private static Integer knapsack1(int[] wArr, int[] vArr, int capacity) {
        int[] b = new int[capacity + 1];
        // i循环商品下标，j循环背包容量
        for (int i = 1; i < wArr.length; i++) {
            for (int j = capacity; j >= wArr[i]; j--) {
                // 如果装第i件商品
                int v1 = b[j - wArr[i]] + vArr[i];
                // 如果不装第i件商品
                int v2 = b[j];
                // 取两者的最大值
                b[j] = NumberUtil.max(v1, v2);
            }

        }
        return b[capacity];
    }

}
