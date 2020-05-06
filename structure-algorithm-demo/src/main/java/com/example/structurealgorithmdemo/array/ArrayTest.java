package com.example.structurealgorithmdemo.array;

/**
 * 数组算法
 *
 * @author Gary
 * @date 2020/4/26 11:49
 **/
public class ArrayTest {

    public static void main(String[] args) {

        int[] arr = {1, 4, 5, 3, 7, 4, 6, 2};

        System.out.println(findDuplicated(arr));

    }

    private static int findDuplicated(int[] arr) {
        int lo = 1;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for (int value : arr) {
                if (value <= mid) {
                    count++;
                }
            }
            // 说明重复数字在 lo-mid 之间
            if (count > mid) {
                hi = mid;
            } else {
                // 说明重复数字在 mid+1-hi之间
                lo = mid + 1;
            }
        }
        return lo;
    }


}
