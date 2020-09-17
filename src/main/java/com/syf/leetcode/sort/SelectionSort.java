package com.syf.leetcode.sort;

/**
 * 选择排序:
 *  首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 *  再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 *  重复第二步，直到所有元素均排序完毕。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {1,4,2,3,8};
        sort(arr);
    }

    private static void sort(int[] arr) {
        int len = arr.length - 1 ;
        if(len <= 1){
            return;
        }
        for(int i = 0 ; i < len ; i ++){
            int k = i ;
            for(int j = i + 1 ; j < len ; j++){
                if(arr[k] > arr[j]){
                    k = j ;
                }
            }
            if(k != i){
                swap(arr,i,k);
            }
        }
    }

    private static void swap(int[] arr, int i, int k) {
        int temp = arr[i] ;
        arr[i] = arr[k] ;
        arr[k] = temp ;
    }
}
