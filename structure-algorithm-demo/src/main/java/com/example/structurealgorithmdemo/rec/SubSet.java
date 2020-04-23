package com.example.structurealgorithmdemo.rec;

import java.util.ArrayList;
import java.util.List;

/**
 * 求子集
 *
 * @author Gary
 * @date 2020/4/21 17:27
 **/
public class SubSet {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        // 先将空集存入结果集
        output.add(new ArrayList<>());

        // 对数组每个数组循环
        for (int num : nums) {
            // 构建含有当前这个数字的子集
            List<List<Integer>> newSubsets = new ArrayList<>();
            // 把当前结果集中所有子集跟该元素组合一下
            for (List<Integer> curr : output) {
                ArrayList<Integer> e = new ArrayList<Integer>(curr) {{
                    add(num);
                }};
                System.out.println(e);
                newSubsets.add(e);
//                List<List<Integer>> newList = new ArrayList<>();
//                newList.add(curr);
//                ArrayList<Integer> temp = new ArrayList<>();
//                temp.add(num);
//                newList.add(temp);
//                newSubsets.addAll(newList);
            }
            // 将含有该数字的子集添加到结果集
            output.addAll(newSubsets);
        }
        return output;
    }

}
