package com.syf.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auth syf
 * @date 2021/1/6 20:16
 * 判断子序列
 */
public class IsSubQueue {
    public static void main(String[] args) {
        String t = "" ;
        String s = "" ;
        boolean flag = isSub(t,s);
    }

    private static boolean isSub(String t, String s) {
        if(t.length() < 1){
            return false ;
        }
        int index = -1 ;
        for (int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            index = t.indexOf(c,index+1);
            if(index == -1 ){
                return false ;
            }
        }
        return true;
    }
}
