package com.study.leetcode.sort.problem02;

import java.util.Arrays;

/**
 * 冒泡排序 两次循环排序，稳定排序，时间复杂度O(N^2)
 */
public class BubboSort {

    public static void sort(int[] arr){
        int length = arr.length;
        for(int i=0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,36,4};
        sort(arr);
        for(int i=0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Arrays.stream(arr).forEach(a-> System.out.print(a+" "));
    }
}
