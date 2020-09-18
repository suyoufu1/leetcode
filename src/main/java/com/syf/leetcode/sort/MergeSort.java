package com.syf.leetcode.sort;

import java.util.Arrays;



/**
 * 归并排序
 *  用分治法和递归来解决
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,5,3,2,8};
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length-1,temp);
        System.out.println(arr);
        for(int num : arr){
            System.out.println(num);
        }
    }

    /**
     * 分治法：
     *  分而治之，将一个大的问题分解成相同的小问题
     *  递归方法来解决分组排序
     * @param arr
     * @return
     */
    private static void sort(int[] arr,int left , int right,int[] temp) {
        if(left < right){
            int mid = (left + right) / 2 ;
            sort(arr,left ,mid ,temp);
            sort(arr,mid+1,right,temp);
            mergeSort(arr,left,mid,right,temp);
        }
    }

    /**
     * 合并
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private static void mergeSort(int[] arr, int left, int mid, int right,int[] temp) {
        int i = 0 ;
        int j = left , k = mid+1;

        while (j<= mid && k <= right){
            if(arr[j] > arr[k]){
                temp[i++] = arr[k++] ;
            }else {
                temp[i++] = arr[j++];
            }
        }
        while (j <= mid){
            temp[i++] = arr[j++];
        }
        while (k <= right){
            temp[i++] = arr[k++];
        }
        for(int t = 0 ; t < i ; t ++){
            arr[left + t] = temp[t];
        }
    }


}
