package com.syf.leetcode.arrayType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @auth syf
 * @date 2020/12/29 15:09
 * 判断两个字符串中的字符相同
 */
public class SameChar {
    public static void main(String[] args) {
        String a = "abc";
        String b = "cba";
        boolean sameChar = isSameChar2(a,b);
        System.out.println(sameChar);
    }

    private static boolean isSameChar(String a, String b) {
        if (isExist(a, b)) return false;
        // 2.利用排序来解决是否相同的字符串
        char[] aCh = a.toCharArray();
        char[] bCh = b.toCharArray();
        Arrays.sort(aCh);
        Arrays.sort(bCh);
        if(String.valueOf(aCh).equals(String.valueOf(bCh))){
            return true;
        }
        return false ;
    }

    private static boolean isExist(String a, String b) {
        // 1.先判断两个字符数组长度是否相同，是否都不为空
        if(a.length()<= 0 || b.length() <= 0 || a.length() != b.length()){
            return true;
        }
        return false;
    }

    // 方法2
    public static Boolean isSameChar2(String a , String b){
        if (isExist(a, b)) return false;
        // 利用hashMap保存字符
        Map<Character,Integer> cache = new HashMap<>(a.length());
        for (Character c : a.toCharArray()){
            cache.put(c,0);
        }
        // 查看hashMap中是否存在b的字符数组
        for (Character c : b.toCharArray()){
            if(cache.containsKey(c)){
                cache.remove(c);
            }
        }
        if(cache.size() == 0){
            return true ;
        }
        return false ;
    }
}
