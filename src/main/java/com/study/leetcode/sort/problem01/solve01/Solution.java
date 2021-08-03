package com.study.leetcode.sort.problem01.solve01;

import java.util.Arrays;

/**最简单的方法：将第二个数组直接copy到第一个数组的后半部分，因为一个数据的后半部分都为0元素
 * 然后将整个nums1 排序
 *
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);


    }
}
