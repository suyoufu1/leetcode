package com.syf.leetcode.array;

/**
 * @auth syf
 * @date 2021/1/8 16:18
 */
public class NumDecodings {
    public static void main(String[] args) {
        String nums = "1720";
        System.out.println("me:"+ numDecodings(nums));
        System.out.println("to:"+numDecodings2(nums));
    }

    private static int numDecodings(String nums) {
        if(nums.length() == 0 || nums.charAt(0)=='0'){
            return 0 ;
        }
        // 判断是否包含字母
        char[] chars = nums.toCharArray();
        for (char c : chars){
            if(!Character.isDigit(c)){
                return 0;
            }
        }
        // 动态规划法
        int[] dp = new int[nums.length()];
        dp[0] = 1 ;
        dp[1] = 1 ;
        // 初始化
        for(int i = 1 ; i < nums.length() ; i ++){
            code(nums, dp, i);
        }
        return dp[nums.length()-1];
    }

    public static int numDecodings2(String s) {
        if(s.charAt(0)=='0')
            return 0;
        //dp[i]表示到i-1位置为止的解密方法数
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            code(s, dp, i);
        }
        return dp[dp.length-1];
    }

    private static void code(String s, int[] dp, int i) {
        if(s.charAt(i-1)!='0')
            dp[i]=dp[i-1];
        if(s.charAt(i-2)=='1'||(s.charAt(i-2)=='2'&&s.charAt(i-1)<='6'))
            dp[i]+=dp[i-2];
    }
}
