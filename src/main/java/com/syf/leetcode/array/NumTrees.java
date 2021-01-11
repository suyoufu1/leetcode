package com.syf.leetcode.array;

import org.springframework.core.annotation.AnnotationUtils;

/**
 * @auth syf
 * @date 2021/1/8 20:41
 * 不同的二叉搜索树
 */
public class NumTrees {
    public static void main(String[] args) {
        int num = 5 ;
        int sum = numTrees(num);
        System.out.println(sum);
        System.out.println(numTrees2(num));
    }

    private static int numTrees(int num) {
        if(num == 0){
            return 0 ;
        }
        int[] dp = new int[num];
        // 初始化
        dp[0] = 1 ;
        dp[1] = 2 ;
        for(int i = 2 ; i < num ; i ++){
            dp[i] = 2*dp[i-1] + dp[i-2];
        }
        return dp[num-1];
    }
    public static int numTrees2(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        // dp[n] +=dp[i-1]*dp[n-i]
        for(int N=2;N<=n;N++){
            for(int i=1;i<N+1;i++){
                dp[N]+=dp[i-1]*dp[N-i];
            }
        }
        return dp[n];
    }
}
