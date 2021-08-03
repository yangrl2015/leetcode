package com.study.leetcode.sort.problem01.solve02;

import java.util.Arrays;

/**最简单的方法：
 * 将两个指针分别指向两个不同的数组，比较两个数组的大小，选出最最小的值放在另外一个新的数组的位置上
 * 然后将新数组的内容拷贝到原来的数组，注意点：
 * 1 循环结束条件，两个都比较完了，即指针都走完了
 * 2 如果一个比较完了，另外一个没有比较完情况的考虑
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
   内存消耗：38.7 MB, 在所有 Java 提交中击败了5.96%的用户
 * 缺点：需要额外的数组，可以参看solve03
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int[] result = new int[m+n];
        int p1 =0;
        int p2 =0;
        int head=0;
        while(p1 <m || p2 < n) {
            if(p1 == m) {
                result[head++] = nums2[p2++];
            }else if(p2 == n) {
                result[head++] = nums1[p1++];
            }else {
                result[head++] = nums1[p1] > nums2[p2] ? nums2[p2++]:nums1[p1++];
            }
        }
        System.arraycopy(result,0, nums1,0,m+n);



    }
}
