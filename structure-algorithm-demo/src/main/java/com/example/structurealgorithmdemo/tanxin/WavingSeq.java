package com.example.structurealgorithmdemo.tanxin;

/**
 * 摇摆队列
 *
 * @author Gary
 * @date 2020/4/21 11:19
 **/
public class WavingSeq {

    public static void main(String[] args) {
        int[] arr = {1, 17, 5, 10, 13, 15, 5, 16, 8};
        System.out.println(getMaxWavingLength(arr));
    }

    public static Integer getMaxWavingLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 求一个队列的最长摇摆长度
        final int BEGIN = 0;
        final int UP = 1;
        final int DOWN = 2;
        int state = BEGIN;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            switch (state) {
                case BEGIN:
                    if (nums[i] > nums[i - 1]) {
                        state = UP;
                        maxLength++;
                    } else if (nums[i] < nums[i - 1]) {
                        state = DOWN;
                        maxLength++;
                    }
                    break;
                case UP:
                    if (nums[i] < nums[i - 1]) {
                        state = DOWN;
                        maxLength++;
                    }
                    break;
                case DOWN:
                    if (nums[i] > nums[i - 1]) {
                        state = UP;
                        maxLength++;
                    }
                    break;
                default:
                    break;
            }
        }
        return maxLength;
    }
}
