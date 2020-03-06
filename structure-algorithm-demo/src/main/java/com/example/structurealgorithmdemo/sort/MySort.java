package com.example.structurealgorithmdemo.sort;

import java.util.Arrays;

/**
 * 复写
 *
 * @author Gary
 * @date 2020/3/5 17:19
 * @since jdk1.8
 **/
public class MySort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 2, 6, 9, 4, 1, 7};
        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        insertionSort(arr);
        selectionSort(arr);
//        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < 0 || start > end || end > arr.length) {
            return;
        }
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i != j) {
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[start] = arr[i];
        arr[i] = pivot;

        quickSort(arr, start, i - 1);
        quickSort(arr, j + 1, end);
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
