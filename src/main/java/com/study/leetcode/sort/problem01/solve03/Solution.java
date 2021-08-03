package com.study.leetcode.sort.problem01.solve03;

/**最简单的方法：
 * 将两个数组从后向前比较，将两个指针分别指向两个不同的数组，比较两个数组的大小，
 * 比较出最大的值放在nums1 的后面部分,这样就不用重新的开辟一个新的空间进行存放新的有序数据了，
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
   内存消耗：38.7 MB, 在所有 Java 提交中击败了5.96%的用户
 * 缺点：需要额外的数组，可以参看solve03
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int p1 =0;
        int p2 =0;
        int head=0;
        while(p1 >=0 || p2 >= 0) {
            if(p1 == -1) {
                nums1[head++] = nums2[p2--];
            }else if(p2 == -1) {
                nums1[head++] = nums1[p1--];
                //或者
                //p1--;
                //continue;
            }else {
                nums1[head++] = nums1[p1] < nums2[p2] ? nums2[p2--]:nums1[p1--];
            }
        }

    }
}
