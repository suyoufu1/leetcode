package com.syf.leetcode.arrayType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 找到一个最长子字符串的长度而不重复的字符串
 *  例如：
 *      abcabcabb -> abc -> 3
 *      bbbbb -> b -> 1
 *      pwwkew -> wke -> 3
 *  思想：
 *      窗口滑动方法[i,j)
 */
public class LongestSubString {
    public static void main(String[] args) {
        int max = maxL2("abcabcabb");
        System.out.println(max);
    }
    public static int maxL(String str){
        int max = 0 ;
        //i表示开始，j表示结尾
        int i = 0 , j = 0;
        Set<Character> set = new HashSet<>();
        while ( i < str.length() && j < str.length()){
            if(!set.contains(str.charAt(j))){
                set.add(str.charAt(j));
                max = Math.max(max,j - i + 1);
                j ++ ;
            }else {
                set.remove(str.charAt(i));
                i ++ ;
            }
        }
        return max;
    }

    public static int maxL2(String sttr){
        int max = 0;
        int i = 0 , j = 0 ;
        Map<Character , Integer> hashMap = new HashMap<>();
        while (i < sttr.length() && j < sttr.length()){
            if(!hashMap.containsKey(sttr.charAt(j))){
                hashMap.put(sttr.charAt(j),j);
                max = Math.max(max , j - i + 1);
                j ++;
            }else {
                Integer index = hashMap.get(sttr.charAt(j));
                for(int k = i ; k <= j ; k ++){
                    hashMap.remove(sttr.charAt(k));
                }
                i = index + j ;
            }
        }
        return max;
    }

}
