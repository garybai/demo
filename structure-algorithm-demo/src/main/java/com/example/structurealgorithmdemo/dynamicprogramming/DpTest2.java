package com.example.structurealgorithmdemo.dynamicprogramming;

/**
 * 动态规划
 *
 * @author Gary
 * @date 2020/4/15 23:54
 **/
public class DpTest2 {

    public static void main(String[] args) {

        // 给定一个整数数组，和一个正整数，能否从数组中跳出一组数，使他们的和等于这个正整数
        int[] arr = {3, 34, 4, 12, 5, 2};
        System.out.println(recSubset(arr, arr.length - 1, 9));
        System.out.println(recSubset(arr, arr.length - 1, 10));
        System.out.println(recSubset(arr, arr.length - 1, 11));
        System.out.println(recSubset(arr, arr.length - 1, 12));
        System.out.println(recSubset(arr, arr.length - 1, 13));
        System.out.println(recSubset(arr, arr.length - 1, 14));
        System.out.println("-----");
        System.out.println(dpSubset(arr, 9));
        System.out.println(dpSubset(arr, 10));
        System.out.println(dpSubset(arr, 11));
        System.out.println(dpSubset(arr, 12));
        System.out.println(dpSubset(arr, 13));
        System.out.println(dpSubset(arr, 14));

    }

    private static boolean dpSubset(int[] arr, int s) {
        boolean[][] subset = new boolean[arr.length][s + 1];
        for (int i = 0; i < arr.length; i++) {
            subset[i][0] = true;
        }
        for (int j = 0; j < s + 1; j++) {
            subset[0][j] = false;
        }
        subset[0][arr[0]] = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < s + 1; j++) {
                if (arr[i] > j) {
                    subset[i][j] = subset[i - 1][j];
                } else {
                    boolean a = subset[i - 1][j - arr[i]];
                    boolean b = subset[i - 1][j];
                    subset[i][j] = a || b;
                }
            }
        }
        return subset[arr.length - 1][s];
    }

    private static boolean recSubset(int[] arr, int i, int s) {
        if (s == 0) {
            return true;
        } else if (i == 0) {
            return arr[0] == s;
        } else if (arr[i] > s) {
            return recSubset(arr, i - 1, s);
        } else {
            boolean a = recSubset(arr, i - 1, s - arr[i]);
            boolean b = recSubset(arr, i - 1, s);
            return a || b;
        }
    }


}
