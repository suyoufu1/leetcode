package com.syf.leetcode.stringType;

/**
 * @auth syf
 * @date 2021/1/2 19:32
 */
public class HuiWen {
    public static void main(String[] args) {
        String s = "abbca";
        boolean flag = huiWen(s);
        System.out.println(flag);
    }

    private static boolean huiWen(String s) {
        if(s.length() <= 0){
            return true;
        }
        int i = 0 , j = s.length() - 1 ;
        while (i < j){
            if(s.charAt(i) != s.charAt(j)){
               return false;
            }
            i ++ ;
            j -- ;
        }
        return true;
    }
}
