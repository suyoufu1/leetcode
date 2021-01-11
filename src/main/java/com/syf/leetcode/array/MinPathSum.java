package com.syf.leetcode.array;

/**
 * @auth syf
 * @date 2021/1/8 15:54
 * 最小路径和
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] nums = {{1,3,1},
                        {1,5,1},
                        {4,2,1}};
        int minSum = minPathSum(nums);
        System.out.println(minSum);
    }

    private static int minPathSum(int[][] nums) {
        int m = nums.length ;
        int n = nums[0].length ;
        if (m == 0 || n == 0){
            return 0;
        }
        // 动态规划法
        int[][] dp = new int[m][n];
        dp[0][0] = nums[0][0] ;
        // 初始化
        for (int i = 1 ; i < m ; i ++){
            dp[i][0] = nums[i][0] + dp[i-1][0];
        }
        for (int i = 1 ; i < n ; i ++){
            dp[0][i] = nums[0][i] + dp[0][i-1];
        }
        // 进行计算最小路径和
        for (int i = 1 ; i < m ; i ++){
            for (int j = 1 ; j < n ; j ++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + nums[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
