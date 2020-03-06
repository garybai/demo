package com.example.structurealgorithmdemo.sort;

import java.util.Arrays;

/**
 * 排序
 *
 * @author Gary
 * @date 2020/3/4 10:48
 * @since jdk1.8
 **/
public class Sort {

    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 1, 3, 2};
        System.out.println(Arrays.toString(arr));
//        bubboSort(arr, arr.length);
//        insertionSort(arr, arr.length);
//        selectionSort(arr, arr.length);
//        int[] arr1 = mergeSort(arr, arr.length);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }



    /**
     * 快速排序
     *
     * @param a:
     * @param left:
     * @param right:
     * @return void
     * @author: Gary
     * @date: 2020/3/5 16:56
     */
    private static void quickSort(int[] a, int left, int right) {
        if (left < 0 || right >= a.length || left > right) {
            return;
        }
        // 选择一个基准数，默认将第一个元素作为基准数
        int pivot = a[left];
        // 两个指针，i从左边开始，j从右边开始
        int i = left;
        int j = right;

        // 当i和j不相遇，循环检索
        while (i != j) {
            // j 从右往左检索比基准数小的就停下
            // 也就是检索到大于等于基准数的就继续循环
            while (a[j] >= pivot && i < j) {
                j--; // j 从右往左移动
            }
            // i 从左往右检索
            while (a[i] <= pivot && i < j) {
                i++; // i 从左往右移动
            }
            // 到这里，i 和 j 都停下了，交换 i 和 j 位置的元素
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        // 如果while条件不成立，也就是 i==j，i 和 j 相遇
        // 交换基准数和相遇位置的元素
        a[left] = a[i];
        a[i] = pivot;

        // 基准数归位后排左边和右边
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);

    }

    /**
     * 归并排序
     *
     * @param a:
     * @param n:
     * @return void
     * @author: Gary
     * @date: 2020/3/4 12:23
     */
    private static int[] mergeSort(int[] a, int n) {
        if (n < 2) {
            return a;
        }
        int mid = n / 2;
        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, n);
        return merge(mergeSort(left, left.length), mergeSort(right, right.length));
    }

    private static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= a.length) {
                result[index] = b[j++];
            } else if (j >= b.length) {
                result[index] = a[i++];
            } else if (a[i] > b[j]) {
                result[index] = b[j++];
            } else {
                result[index] = a[i++];
            }
        }
        return result;
    }

    /**
     * 选择排序
     *
     * @param a:
     * @param n:
     * @return void
     * @author: Gary
     * @date: 2020/3/4 12:00
     */
    private static void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            // 内层循环找到最小的数
            for (int j = i; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = tmp;
        }
    }

    /**
     * 插入排序
     *
     * @param a:
     * @param n:
     * @return void
     * @author: Gary
     * @date: 2020/3/4 11:20
     */
    private static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        // 外层从1开始循环，默认第0个元素是已排序的
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            // 内层循环，在已排序的元素中倒序比较
            for (; j >= 0; j--) {
                // 如果该元素大于新元素，那么就将该元素下移一位
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    // 如果该元素小于新元素，跳出本次循环
                    break;
                }
            }
            // 将新元素插入进去
            a[j + 1] = value;
        }
    }

    /**
     * 冒泡排序
     *
     * @param a:
     * @param n:
     * @return void
     * @author: Gary
     * @date: 2020/3/4 11:09
     */
    private static void bubboSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        // 外层把所有元素循环一次，
        for (int i = 0; i < n; i++) {
            // 内层循环该元素和相邻元素比较
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

}
