package com.syf.leetcode.array;

/**
 * @auth syf
 * @date 2021/1/8 13:36
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] gird = {{0,0,0},
                        {0,1,0},
                        {0,0,0}};
        int sum = uniquePathsWithObstacles(gird);
        System.out.println(sum);
    }

    private static int uniquePathsWithObstacles(int[][] gird) {
        int m = gird.length;
        if(m < 1){
            return 0;
        }
        int n = gird[0].length;
        if(n < 1){
            return 0 ;
        }
        if(gird[0][0] == 1){
            return 0;
        }
        int[][] dp = new int[m][n] ;
        // 初始化
        for (int i = 0 ; i < m ; i ++){
            if(gird[i][0] == 0){
                dp[i][0] = 1 ;
            }else {
                dp[i][0] = 0 ;
            }
        }
        for (int i = 0 ; i < n ; i ++){
            if(gird[0][i] == 0){
                dp[0][i] = 1 ;
            }else {
                dp[0][i] = 0 ;
            }
        }
        for (int i = 1 ; i < m ; i ++){
            for (int j = 1 ; j < n ; j ++){
                if(gird[i][j] == 1){
                    dp[i][j] = 0 ;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] ;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
