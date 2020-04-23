package com.example.structurealgorithmdemo.tanxin;

/**
 * 钱面额
 *
 * @author Gary
 * @date 2020/4/21 09:58
 **/
public class Money {

    public static void main(String[] args) {
        // 面额数组
        int[] arr = {200, 100, 20, 10, 5, 1};
        // 总共支付金额
        int x = 628;
        System.out.println(use(arr, x));
    }

    public static Integer use(int[] arr, int x) {
        int count = 0;
        for (int item : arr) {
            int value = x / item;
            count += value;
            x = x - value * item;
            System.out.print("需要面值为" + item + "的钞票" + value + "张\t");
            System.out.println("剩余需要支付" + x);
        }
        return count;
    }
}
