package com.syf.leetcode.sort;



/**
 * 冒泡排序
 *  比较两个相邻的两个元素，如果第一个比第二个大，就交换它们
 *  对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 *  针对所有的元素重复以上的步骤，除了最后一个。
 *  持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,3,5,2,10,7};
        sort(arr);
    }

    private static void sort(int[] arr) {
        int len = arr.length -1 ;
        if(len <= 1){
            return;
        }
        for(int i = 1 ; i < len ; i ++){
            Boolean flag = true;
            for(int j = 0 ; j <= len - i ; j ++){
                if(arr[j]  > arr[j+1]){
                    swap(arr,j,j+1);
                    flag = false ;
                }
            }
            if(flag){
                break;
            }
        }

    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j] ;
        arr[j] = arr[i] ;
        arr[i] = temp;
    }

}
