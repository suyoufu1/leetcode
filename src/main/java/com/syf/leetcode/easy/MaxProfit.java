package com.syf.leetcode.easy;

import java.util.Stack;

/**
 * @auth syf
 * @date 2020/9/19 19:27
 * @des 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] profit = {7, 1, 5, 3, 6, 4};
        int max = maxProfit4(profit);
        System.out.println(max);
    }

    /**
     * 方法一：暴力法
     *
     * @param profit
     * @return
     */
    private static int maxProfit(int[] profit) {
        int max = 0;
        for (int i = 0; i < profit.length; i++) {
            for (int j = i + 1; j < profit.length; j++) {
                int temp = profit[j] - profit[i];
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    /**
     * 方法二： 单调栈
     * 用哨兵来监控
     *
     * @param profit
     * @return
     */
    private static int maxProfit2(int[] profit) {
        if (profit.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        Stack<Integer> stack = new Stack<>();
        for (int x : profit) {
            //判断是否空栈并且栈顶元素大于入栈的元素
            if (!stack.isEmpty() && stack.peek() > x) {
                maxProfit = Math.max(maxProfit, stack.peek() - stack.firstElement());
                while (!stack.isEmpty() && stack.peek() >= x) {
                    stack.pop();
                }
            }
            //入栈
            stack.push(x);
        }
        if (!stack.isEmpty()) {
            maxProfit = Math.max(maxProfit, stack.peek() - stack.firstElement());
        }
        return maxProfit;
    }

    /**
     * 方法三：动态规划法
     * T[i][0] = max(T[i-1][0] , T[i-1][1] + p[i]);
     * T[i][1] =max(T[i-1][1],-p[i])
     *
     * @param profit
     * @return
     */
    private static int maxProfit3(int[] profit) {
        /**
         * if(profit.length <= 1){
         *             return 0 ;
         *         }
         *         int p = 0 , p1 = -profit[0];
         *         for(int i = 1 ; i < profit.length ; i ++){
         *            p = Math.max(p,p1+profit[i]);
         *            p1 = Math.max(p1,-profit[i]);
         *         }
         *         return p;
         *     }
         */
        if (profit.length <= 1) {
            return 0;
        }
        int[][] dp = new int[profit.length][2];
        //初始化
        dp[0][0] = 0;
        dp[0][1] = -profit[0];
        for (int i = 1; i < profit.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + profit[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -profit[i]);
        }
        return dp[profit.length - 1][0];
    }

    /**
     * 双指针思想
     * @param profit
     * @return
     */
    private static int maxProfit4(int[] profit){

        int len = profit.length - 1 ;
        if(len == 0){
            return 0;
        }
        int i = 0 , j = 1 ;
        int max = 0 ;
        while (j < len) {
            if (profit[i] > profit[j]) {
                i = j;
                j = i + 1;
            } else {
                if (max < profit[j] - profit[i]) {
                    max = profit[j] - profit[i];
                }
                j++;
            }
        }
        return max ;
    }
}
