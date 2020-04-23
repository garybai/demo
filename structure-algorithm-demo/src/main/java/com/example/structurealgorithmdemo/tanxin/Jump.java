package com.example.structurealgorithmdemo.tanxin;

/**
 * 跳跃游戏
 *
 * @author Gary
 * @date 2020/4/21 14:01
 **/
public class Jump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums1 = {3, 2, 1, 0, 4};
        System.out.println(jump(nums));
        System.out.println(jump(nums1));
        System.out.println(minJumpTimes(nums));

        int[][] a = {{10,16},{2,8}};
        System.out.println(a[0][2]);
    }

    public static Boolean jump(int[] nums) {
        // 记录能到达的最远距离
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 表示目前的第i个位置是可达的
            if (i <= max) {
                // 将可到达的最远距离更新
                max = Math.max(max, i + nums[i]);
                // 可达最远距离大于等于数组尾
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Integer minJumpTimes(int[] nums) {
        // 能跳到的最远距离
        int max = 0;
        // 跳跃次数
        int count = 0;
        // 记录每一次跳跃是到达的那个点
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新能跳到的最远距离
            max = Math.max(max, i + nums[i]);
            // 循环到跳跃可达点时，跳跃次数+1，可达点更新
            if (i == end) {
                count++;
                end = max;
            }
        }
        return count;
    }
}
