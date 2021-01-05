package com.syf.leetcode.stringType;

import java.util.HashMap;
import java.util.Map;

/**
 * @auth syf
 * @date 2020/12/29 15:37
 * 计算一组字符串集合可以组装成的回文字符串的最大长度
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String a = "babad";
        int longest = longestPail(a);
        String s = longthWenhui(a);
        System.out.println(longest);
        System.out.println(s);
    }

    private static int longestPail(String a) {
        if (a.length() == 0){
            return 0 ;
        }
        Map<Character,Integer> cacheNum = new HashMap<>(a.length());
        // 统计字符个数
        for (Character c  : a.toCharArray()){
            if(cacheNum.containsKey(c)){
                Integer value = cacheNum.get(c);
                cacheNum.put(c,value+1);
            }else {
                cacheNum.put(c,1);
            }
        }
        boolean signFlag = false ;
        int longLength = 0 ;
        for (Map.Entry<Character,Integer> map : cacheNum.entrySet()){
            Integer value = map.getValue();
            // 判断有单个字符 找出单个字符选择其中一个作为中间的值
            if(value == 1){
                signFlag = true ;
            }
            if (value > 1){
                // 判断是奇数还是偶数
                if(value % 2 == 0 ){
                    longLength += value ;
                }else {
                    longLength += value-1 ;
                }
            }
        }
        if(signFlag){
            longLength ++ ;
        }
        return longLength;
    }

    /**
     * 动态规划法来求解
     *  p(i,j)=p(i+1,j-1)^(Si==Sj) n>2
     */
    public static String longthWenhui(String s){
        if(s.length() <= 0){
            return "" ;
        }
        int n = s.length() ;
        // 定义空间
        boolean dp[][] = new boolean[n][n];
        String res = "";
        // 最外层遍历定义长度
        for(int l = 0 ; l < n ; l ++){
            // 内层进行最优解的计算
            for (int i = 0 ; i+ l < n ; i ++){
                int j = i + l ;
                // 如果长度是1
                if(l == 0){
                    dp[i][j] = true ;
                }else {
                    boolean b1 = s.charAt(i) == s.charAt(j);
                    if( l == 1){//长度是2
                        boolean b = b1;
                        dp[i][j]= b;
                    }else {
                        dp[i][j] = dp[i+1][j-1] && b1;
                    }
                }
                // 保存最优解
                if(dp[i][j] && l+1 > res.length()){
                    res = s.substring(i,j+1);
                }
            }
        }
        return res ;
    }
}
