package com.syf.leetcode.array;

/**
 * @ClassName
 * @Author syf
 * @Date 2021/1/5
 * @Version
 * 买卖股票
 */
public class BuyStock {
    public static void main(String[] args) {
        int[] nums = {7,6,4};
        int sum = buyStock(nums);
        System.out.println (sum);
    }

    private static int buyStock(int[] nums) {
        int len = nums.length ;
        if(len < 1){
            return 0;
        }
        int[][] dp = new int[len][len];

        // 初始化
//        for (int i = 0 ; i < len ; i ++){
//            for (int j = 0 ; j < len ; j ++) {
//                dp[i][j] = 0;
//            }
//        }
        int max = 0 ;
        int min = nums[0] ;
        for (int i = 1 ; i < len ; i ++){
            max = Math.max ( nums[i] - min,max );
            min = Math.min ( nums[i],min );
        }

//        for (int i = 0 ; i < len - 1; i ++){
//            for (int j = i + 1 ; j < len ; j ++){
//                dp[i][j] =   nums[j] - nums[i];
//                if(dp[i][j] > max ){
//                    max = dp[i][j];
//                }
//            }
//        }
        return max;
    }

}
