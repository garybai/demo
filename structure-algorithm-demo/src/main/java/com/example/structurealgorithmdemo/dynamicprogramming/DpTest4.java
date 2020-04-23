package com.example.structurealgorithmdemo.dynamicprogramming;

import java.util.Arrays;

/**
 * 动态规划
 *
 * @author Gary
 * @date 2020/4/15 23:54
 **/
public class DpTest4 {

    public static void main(String[] args) {
        // 给定一个正整数，使得这个正整数是由完全平方数相加得到，找到最少的完全平方数的情况
        int n = 12;
        System.out.println(findLeastSquare(n));
    }

    private static Integer findLeastSquare(int n) {
//        int[] sq = new int[(int) (Math.sqrt(n - 1))+1];
//        for (int i = 1; i <= n; i++) {
//            if (i * i < n) {
//                sq[i - 1] = i * i;
//            } else {
//                break;
//            }
//        }
        int[] sq = {0, 1, 4, 9};
        System.out.println(Arrays.toString(sq));
        int[] dp = new int[n + 1];
        for (int i = 1; i < sq.length - 1; i++) {
            for (int j = sq[i]; j <= n; j++) {
                dp[j] = Integer.MAX_VALUE;
                int a = dp[j - sq[i]] + 1;
                int b = dp[j];
                dp[j] = Math.min(a, b);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }


}
