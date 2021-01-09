package com.syf.leetcode.array;

import java.util.Map;

/**
 * @ClassName
 * @Author syf
 * @Date 2021/1/5
 * @Version
 * 计算最大乘积
 */
public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int product = maxProduct(nums);
        System.out.println (product);
    }

    /**
     * 动态规划法：
     *  1）状态设计
     *      设计两个状态->最大值和最小值 df[i][1] df[i][0]
     *  2）推到状态转移方程
     *      nums[i] >= 0的情况
     *          df[i][1] = Max(df[i][1]*nums[i],nums[i])
     *          df[i][0] - Min(df[i][0]*num[i],nums[i])
     *      nums[i] < 0的情况
     *          df[i][1] = Max(df[i][0]*nums[i],nums[i])
     *          df[i][0] - Min(df[i][1]*num[i],nums[i])
     *  3)考虑初始值
     *  4)输出
     *  5）考虑表格复用
     *
     * @param nums
     * @return
     */
    private static int maxProduct(int[] nums) {
        int len = nums.length ;
        if(len < 1){
            return 0;
        }
        // 设计状态
        int[][] dp = new int[len][2] ;
        // 初始化
        dp[0][1] = nums[0] ;
        dp[0][0] = nums[1] ;
        for (int i = 1 ; i < len ; i++){
            if(nums[i] >= 0){
                dp[i][1] = Math.max ( dp[i-1][1] * nums[i] , nums[i] );
                dp[i][0] = Math.min ( dp[i-1][0] * nums[i] , nums[i] );
            }else {
                dp[i][1] = Math.max ( dp[i-1][0] * nums[i] , nums[i] );
                dp[i][0] = Math.min ( dp[i-1][1] * nums[i] , nums[i] );
            }
        }
        // 获取最大值
        int res = dp[0][1] ;
        for (int i = 1 ; i < len ; i ++){
            res = Math.max ( dp[i][1],res );
        }
        return res;
    }
}
