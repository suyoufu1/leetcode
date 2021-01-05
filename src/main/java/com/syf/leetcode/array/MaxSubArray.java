package com.syf.leetcode.array;

import sun.java2d.cmm.CMSManager;


/**
 * @auth syf
 * @date 2021/1/5 15:42
 * 最大子序和
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {};
        maxSubArray(nums);
        maxSubArray2(nums,0,nums.length-1);
    }

    private static int maxSubArray(int[] nums) {
        // 用暴力法
        if (nums.length < 1){
            return 0;
        }
        int maxSum  = 0 ;
        for (int i = 0 ; i < nums.length ; i ++){
            int cur = 0 ;
            for (int j = i ; j < nums.length  ; j ++){
                cur += nums[j]  ;
                if(cur > maxSum){
                    maxSum = cur ;
                }
            }
        }
        return maxSum;
    }

    // 分治法 + 递归
    private static int maxSubArray2(int[] nums,int left , int right){
        if (nums.length < 1){
            return 0;
        }
        // 二分法
        int center = nums.length >> 1 ;
        int maxLeftSum = maxSubArray2(nums,left,center);
        int maxRightSum = maxSubArray2(nums,center+1,right);
        // 边界处也可能是最大的
        int leftMaxBorderSum  = 0 , curLeftBorderSum = 0 ;
        for (int i = center ; i >= left ; i ++){
            curLeftBorderSum += nums[i];
            if(curLeftBorderSum > leftMaxBorderSum){
                leftMaxBorderSum = curLeftBorderSum ;
            }
        }
        int rightMaxBorderSum  = 0 , curRightBorderSum = 0 ;
        for (int i = center+1 ; i <= right ; i ++){
            curRightBorderSum += nums[i] ;
            if (curRightBorderSum > maxRightSum){
                rightMaxBorderSum = curRightBorderSum ;
            }
        }
        return max(maxLeftSum,maxRightSum,rightMaxBorderSum + leftMaxBorderSum);
    }

    private static int max(int maxLeftSum, int maxRightSum, int i) {
        int max = Math.max(maxLeftSum, maxRightSum);
        return Math.max(max,i);
    }
    // 动态规划法 dp[i] = dp[i-1] + num[i]
    private static int maxSubArray3(int[] nums){
        if (nums.length < 1){
            return 0;
        }
        int res = nums[0] ;
        int[] dp = new int[nums.length+1];
        // 初始化
        for (int i = 0 ; i < nums.length ; i ++){
            dp[i] = 0 ;
        }
        for (int i = 0 ; i < nums.length ; i ++){
            dp[i+1] = Math.max(dp[i] + nums[i],nums[i]) ;
            res = Math.max(dp[i+1] , res);
        }
        return res ;
    }

}
