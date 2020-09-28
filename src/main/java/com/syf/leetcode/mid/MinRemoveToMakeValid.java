package com.syf.leetcode.mid;

import java.util.*;

/**
 * @auth syf
 * @date 2020/9/28 22:30
 * @des 移除无效的括号
 */
public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        String s = minRemoveToMakeValid("ab(ccc)(((");
        System.out.println(s);
    }
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] record = new boolean[s.length()];
        for(int i = 0 ; i < s.length() ; i ++){
            if(s.charAt(i) == '('){
                stack.push(i);
                record[i] = true ;
            }
            if(s.charAt(i)==')'){
                if(stack.isEmpty()){
                    record[i] = true ;
                }else {
                    record[stack.pop()] = false ;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ; i < s.length() ; i ++){
            if(!record[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
