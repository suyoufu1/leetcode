package com.syf.leetcode.arrayType;

import java.util.HashMap;

/**
 * 最长回文子字符串
 * 最长的回文子字符串
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = longestP("babad");
        System.out.println(s);
        String s1 = longestPalindrome2("ababa");
        System.out.println(s1);
    }

    /**
     * 暴力破解法
     * @param s
     * @return
     */
    public  static String longestP(String s){
        //定义最大回文大小
        int maxLen = 0 ;
        String longStr = "" ;
        for (int i = 0 ; i < s.length() ; i ++){
            for(int j = s.length() - 1 ; j > i ; j --){
                //判断是否为回文数
                if(isPalind(i,j,s)){
                    int sublen = j - i + 1 ;
                    if(sublen > maxLen){
                        longStr = s.substring(i,j+1);
                        maxLen = sublen ;
                    }
                }
            }
        }
        return longStr;
    }

    /**
     * 判断字符串是否为回文字符串
     * @param startIndex
     * @param endIndex
     * @param s
     * @return babad
     */
    private static boolean isPalind(int startIndex, int endIndex, String s) {
        int i = startIndex ;
        int j = endIndex ;
        for( ; j >= i ; j -- , i ++){
            if(s.charAt(j)!=s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    /**
     * 5、 Longest Palindromic Substring
     * 优化解法二：动态规划解法
     * 思路：
     * 利用dp[j][i]表示字符串区间[j,i]是否为回文串,则dp[i][j]
     * 即如果我们找到两个相同的字符S[i]和S[j],在两种情况下他们能构成回文串：
     *      第一种：这两个字符位置相邻或者就是同一个字符 即：
     *          dp[j][i] = (S[i]==S[j]) && (i-j<2)
     *      第二种：这两个字符所包含的中间字符串为回文串,这个时候我们只需要验证：
     *          dp[j][i] = (S[i]==S[j]) && (dp[j+1][i-1] && i-j>1)
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s){
        int length = s.length();
        boolean[][] b = new boolean[length][length] ;
        String longStr = "";
        int maxLen = 0 ;
        if(s.equals("")){
            return "";
        }
        for(int i = 0 ; i < length ; i ++){
            for(int j = 0; j <= i ; j ++){
                b[j][i] = (s.charAt(i) == s.charAt(j)) && (i -j < 2 || b[j+1][i-1]);
                if(b[j][i] && maxLen < i-j+1 ){
                    maxLen =  i-j+1 ;
                    longStr = s.substring(j,i+1);
                }
            }
        }
        return longStr;
    }
}
