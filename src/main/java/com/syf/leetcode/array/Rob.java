package com.syf.leetcode.array;

/**
 * @auth syf
 * @date 2021/1/6 19:50
 *
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int sum = rob(nums);
        System.out.println(sum);
    }

    private static int rob(int[] nums) {
        // 动态规划的思想
        if (nums.length < 1){
            return 0;
        }
        int[] dp = new int[nums.length + 1] ;
        dp[0] = 0 ;
        dp[1] = nums[0] ;
        for (int i = 2 ; i <= nums.length ; i ++){
            dp[i] =Math.max( dp[i-2] + nums[i-1] , dp[i-1]);
            System.out.println(dp[i]);
        }
        return dp[nums.length];
    }
}
