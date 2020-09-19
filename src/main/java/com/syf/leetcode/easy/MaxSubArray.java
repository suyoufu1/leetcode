package com.syf.leetcode.easy;

/**
 * @auth syf
 * @date 2020/9/19 16:19
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int []arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = maxSubArray(arr);
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
}
