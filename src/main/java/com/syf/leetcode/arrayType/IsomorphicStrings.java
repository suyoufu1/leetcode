package com.syf.leetcode.arrayType;

import java.util.HashMap;
import java.util.Map;

/**
 * @auth syf
 * @date 2020/12/29 16:15
 * 判断两个字符串是否属于同构
 * 例如：agg bcc 是
 * boo arc 不是
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        String a = "";
        String b = "";
        boolean oomph = isOomph(a, b);
        System.out.println(oomph);
    }

    private static boolean isOomph(String a, String b) {
        // 判断是否为空 是否长度相同
        if (a.length() <= 0 || b.length() <= 0 || a.length() != b.length()) {
            return false;
        }
        // 保存字符串，有多个字符串
        /**
         *  参数说明：key表示字符 value: map -> 出现的位置，出现的次数
         */
        Map<Character, Map<Integer, Integer>> cacheMap = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (cacheMap.containsKey(a.charAt(i))) {
                Map<Integer, Integer> map = cacheMap.get(a.charAt(i));
                Integer integer = map.get(i);
                map.put(i, integer + 1);
                cacheMap.put(a.charAt(i), map);
            } else {
                Map<Integer, Integer> temp = new HashMap<>();
                temp.put(i, 1);
                cacheMap.put(a.charAt(i), temp);
            }
        }
        for (int i = 0; i < a.length(); i++) {

        }
        return false;
    }

    // 记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构。
    public boolean isIsomorphic(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }
    public boolean isIsomorphic2(String s , String t){
        int[] pOfS = new int[256];
        int[] pOFT = new int[256];
        for (int i = 0 ; i < s.length() ; i ++){
            char sc = s.charAt(i);
            char tc = t.charAt(i) ;
            if(pOfS[sc] != pOFT[tc]){
                return false ;
            }
            pOfS[sc] = i + 1 ;
            pOFT[tc] = i + 1 ;
        }
        return true ;
    }
}
