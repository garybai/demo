package com.example.structurealgorithmdemo.tanxin;

import java.util.Arrays;

/**
 * 糖果
 *
 * @author Gary
 * @date 2020/4/21 10:28
 **/
public class Candy {

    public static void main(String[] args) {
        int[] candies = {6, 1, 20, 3, 8};
        int[] children = {5, 10, 2, 9, 15, 9};
        System.out.println(mostChildren(candies, children));
    }

    public static Integer mostChildren(int[] candies, int[] children) {
        Arrays.sort(candies);
        System.out.println(Arrays.toString(candies));
        Arrays.sort(children);
        System.out.println(Arrays.toString(children));
        int candy = 0;
        int child = 0;
        while (candy < candies.length && child < children.length) {
            // 当糖果满足孩子的时候孩子+1
            if (candies[candy] >= children[child]) {
                child++;
            }
            // 无论是否满足，糖果都+1
            candy++;
        }
        return child;
    }
}
