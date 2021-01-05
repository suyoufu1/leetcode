package com.syf.leetcode.easy;


/**
 * @auth syf
 * @date 2020/9/19 16:19
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int []arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = frame(arr);
        System.out.println(sum);
    }

    /**
     * 方法一： 动态规划法
     *      将问题数学化，用fi来记录当前最大的最大子序列和 ，那么fi和fi-1是相关的，只需要 fi = max(fi-1 + num[i] , num[i])
     * @param nums
     * @return
     */
    private static int maxSubArray(int[] nums) {
        int pre = 0 ,maxSum = nums[0];
        for (int x : nums){
            pre = Math.max(pre+x,x);
            maxSum = Math.max(maxSum , pre);
        }
        return maxSum;
    }

    /**
     * 确定“状态”-》利用dp数据-》确定“选择”-》base case
     *  状态：变量 子序列之和 maxSum
     *  利用dp数据: dp[] 记录当前数据之和
     *  选择：状态转移方程 fi = Math.max(fi-1 + nums[i] , nums[i])
     *  base case:进行编码
     * @param nums
     * @return
     */
    public static int frame(int[] nums){
        if(nums.length == 0){
            return -1;
        }
        // 备忘录
        int[] dp = new int[nums.length];
        // 初始化
        for (int i = 0 ; i < nums.length ; i ++){
            dp[i] = 0 ;
        }
        dp[0] = nums[0] ;
        // 记录最大子序列之和
        int maxSum = 0 ;
        for(int i = 1 ; i < nums.length ; i ++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            maxSum = Math.max(maxSum,dp[i]);
        }
        return maxSum;
    }
}
