package com.syf.leetcode.array;

/**
 * @auth syf
 * @date 2021/1/7 18:11
 * 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] nums = {10,15,20} ;
        int min = minCostClimbingStairs(nums);
        System.out.println(min);
    }

    private static int minCostClimbingStairs(int[] nums) {
        if(nums.length < 1){
            return 0 ;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0] ;
        dp[1] = nums[1] ;
        for (int i = 2 ; i < nums.length ; i ++){
            dp[i] = Math.min(dp[i-2]+nums[i] ,dp[i-1]);
        }
        return Math.min(dp[nums.length - 1 ],dp[nums.length - 2]);

    }
}
