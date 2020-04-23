package com.example.structurealgorithmdemo.tanxin;

import java.util.LinkedList;

/**
 * 移除k个数字使结果最小
 *
 * @author Gary
 * @date 2020/4/21 12:17
 **/
public class RemoveK {

    public static void main(String[] args) {
        String num = "1432219";
//        String num = "10206534";
        int k = 4;
        System.out.println(removeK(num, k));
    }

    public static String removeK(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] digits = num.toCharArray();
        // 数字从高位往低位循环
        for (char digit : digits) {
            // 如果栈不为空，数字还没移除完毕，并且当前数字比栈顶元素小的情况下，弹出栈顶，也就是移除较大数字
            while (stack.size() > 0 && k > 0 && digit < stack.peekLast()) {
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }
        // 如果循环完毕，没有移除够k个，就从栈顶弹出剩余需要删除的数字
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        // 考虑前导0的情况
        boolean leadingZero = true;
        for (char digit : stack) {
            // 如果一直是前导0，不往StringBuilder添加
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
