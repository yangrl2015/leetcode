package com.study.leetcode.sort.problem02;

import java.util.Arrays;

/**
 * 合并排序
 * 首先将数组分为一个一个子序列，然后将每个子序列合并排序，
 * 每个子序列都是有序的。
 * 时间复杂度：O(logN)
 * 空间复杂读：O(N)
 * 稳定性：稳定
 * 任何一个排序都可以实现一个不稳定排序
 * 稳定性：如何一个序列，a[i]和a[i++] 相同则，顺序不需要变
 * 使用：外部排序：内存放不下大量数据，可以将数据分割为不同的段加载到内村中进行排序
 * 冒泡排序：稳定
 * 直接插入排序：稳定 直接插入顺序越有序越快，最快时间时间为O(N)
 * 归并排序：稳定
 * 其他都不稳定
 * 堆排序的空间复杂度为O(1)
 */
public class MergeSort {
    public static void sort(int[] arr,int low, int height){
        if(low >= height) return;
        int mid = (low+height)/2;
        sort(arr, low, mid);
        sort(arr, mid+1, height);
        mergeSort(arr,low,mid,height);
    }
    public static void mergeSort(int[] arr, int low, int mid, int height){

        int[] leftArray = Arrays.copyOfRange(arr,low, mid+1);
        int[] rightArray = Arrays.copyOfRange(arr,mid+1, height+1);
        System.out.println("leftArray:"+Arrays.toString(leftArray));
        System.out.println("rightArray:"+Arrays.toString(rightArray));

        int [] res = new int[height-low+1];
        int pLeft = low;
        int pRight = mid+1;
        int i = 0;
        while(pLeft <= mid && pRight <= height){ //两个归并段都有数据
          res[i++] = arr[pLeft]<= arr[pRight]?arr[pLeft++]:arr[pRight++]; //这里判断用=是为了稳定性，
        }
        while(pLeft <= mid) {
            res[i++] = arr[pLeft++];
        }
        while(pRight <= height) {
            res[i++] = arr[pRight++];
        }


         System.out.println(" res arr:"+Arrays.toString(res));
        System.arraycopy(res,0,arr,low,res.length); //这里注意要将数组拷贝到开始的low位置
        System.out.println("result arr:"+Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] a = {5,3,3,4,6,2,1};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
