package com.example.structurealgorithmdemo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 *
 * @author Gary
 * @date 2020/4/12 17:39
 **/
public class LeetCode1 {

    public static void main(String[] args) {

        /**
         * 给定一个无序的整数数组arr，和一个整数target，返回arr里面的两个值之和是target的下标
         */
        int[] arr = {1, 4, 8, 2, 5, 7, 3, 6};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(arr, target)));

    }

    private static int[] twoSum(int[] arr, int target) {
        int[] value = new int[2];
        if (arr.length <= 1){
            return value;
        }
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int b = target - a;
            if (map.containsKey(b)) {
                value[0] = i;
                value[1] = map.get(b);
                break;
            } else {
                map.put(a, i);
            }
        }

        return value;
    }


}
