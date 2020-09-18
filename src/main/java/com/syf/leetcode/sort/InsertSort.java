package com.syf.leetcode.sort;

/**
 * 插入排序
 *  将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 *  从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1,4,2,3,5};
        insertSort(arr);
    }
    //插入排序是O(n^2)
    private static void insertSort(int[] arr) {
        for(int i = 1 ; i < arr.length ; i ++){
            int temp = arr[i];
            int j = i ;
            //和已经排好序的进行比较大小
            while (j > 0 && temp < arr[j]){
                arr[j] = arr[j-1];
                j -- ;
            }
            //插入
            if(j != i){
                arr[j] = temp ;
            }
        }
    }
}
