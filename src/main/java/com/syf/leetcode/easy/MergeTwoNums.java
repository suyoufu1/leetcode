package com.syf.leetcode.easy;


import java.util.Arrays;

/**
 * @auth syf
 * @date 2020/9/19 18:37
 * @des 合并两个有序数组
 *      s1 = {1,2,3,4,5,6,10,0,0,0,0,0}
 *      s2 = {3,7,8,9,11}
 *      merge = {1,2,3,3,4,5,6,7,8,9,10,11}
 *      temp ={1,2,3,4,5,6,10
 *      i , j , k
 */
public class MergeTwoNums {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        num1 = merge2(num1,3,num2,3);
        for(int x : num1){
            System.out.println(x);
        }
    }

    /**
     * 时间复杂度 : O((n + m)log(n + m))
     * 空间复杂度 : O(1)O(1)。
     * @param num1
     * @param num2
     * @return
     */
    private static int[] merge(int[] num1, int[] num2) {
        /**
         *  for(int i = 0 ; i < num2.length ; i ++){
         *     num1[num1.length  + i] = num2[i];
         *      TODO
         *  }
         */
        System.arraycopy(num2,0,num1,3,num2.length);
        Arrays.sort(num1);
        return num1 ;
    }
    /**
     * 双指针 / 从前往后
     */
    private static int[] merge2(int[] num1,int m , int[] num2,int n) {
        int[] numCopy = new int[m];
        System.arraycopy(num1,0,numCopy,0,m);
        //双指针
        int p1 = 0 ;
        int p2 = 0 ;
        //指向num1
        int p = 0 ;
        while ((p1 < m) && (p2 < n)){
            num1[p++] = (numCopy[p1] > num2[p2]) ? num2[p2++] : numCopy[p1 ++];
        }
        if(p1 < m){
            System.arraycopy(numCopy,p1,num1,p1 + p2 ,m + n - p1 - p2);
        }
        if(p2 < n){
            System.arraycopy(num2,p2,num1,p1+p2,m+n-p1-p2);
        }
        return num1;
    }

    public static int[] frame(int[] nums1 , int[] nums2){
        // 利用双指针
        int i = 0 , j = 0 ;
        // 合并后数组
        int[] res = new int[nums1.length + nums2.length];
        int k = 0 ;
        while ((i < nums1.length) && (j < nums2.length)){
            res[k++] = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
        }
        while (i < nums1.length){
            res[k++] = nums1[i] ;
        }
        while (j < nums2.length){
            res[k++] = nums2[j] ;
        }
        return res;
    }
}
