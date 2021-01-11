package com.syf.leetcode.binarySearch;

/**
 * @ClassName
 * @Author syf
 * @Date 2021/1/9
 * @Version x 的平方根
 */
public class Sqrt {
    public static void main(String[] args) {
        int x = 8;
        int res = sqrt ( x );
        System.out.println (res);
    }

    private static int sqrt(int x) {
        if (x < 0) {
            return -1;
        }
        int res = 0 ;
        // 利用二分法进行获取
        /**
         * 什么是二分法
         *  公式：mid = l + (r-l)/2
         */
        int l = 0 , r = x ;
        while (l < r){
            int mid = l + (r-l)/2 ;
            if (mid*mid <= x){
                res = mid ;
                l = mid + 1 ;
            }else {
                r = mid - 1 ;
            }
        }
        return res ;
    }
}
