package com.syf.leetcode.array;

/**
 * @auth syf
 * @date 2021/1/7 20:49
 * 最小路径和
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m = 3 , n = 2 ;
        int sum = uniquePaths(m , n );
        System.out.println(sum);
    }

    private static int uniquePaths(int m, int n) {
        if(m <= 0 || n  <= 0){
            return 0 ;
        }
        if(m == 1 && n == 0 || m == 0 && n == 1){
            return 1 ;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 0 ;
       for (int i = 0 ; i < m ; i ++){
           dp[i][0] = 1 ;
       }
       for (int j = 0 ; j < n ; j ++){
           dp[0][j] = 1 ;
       }
        for (int i = 1 ; i < m ; i ++){
            for (int j = 1 ; j < n ; j ++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }

}
