package com.syf.leetcode.array;

/**
 * @ClassName
 * @Author syf
 * @Date 2021/1/5
 * @Version
 * 给定一个数，计算不相邻的之和最大的那个数
 */
public class Masseur {
    public static void main(String[] args) {
        int[] nums = {2,1,4,5,3,1,1,3};
        int sum = masseur(nums);
        System.out.println (sum);
    }

    private static int masseur(int[] nums) {
        int len = nums.length ;
        if(len < 1){
            return 0 ;
        }
        if(len == 1){
            return nums[0] ;
        }
        int[] dp = new int[len];
        dp[0] = nums[0] ;
        dp[1] = nums[1] ;
        for (int i = 2 ; i < len ; i ++){
            dp[i] = dp[i-2] + nums[i];
            System.out.println (dp[i]);
        }
        return Math.max ( dp[len-1],dp[len - 2] );
    }
}
