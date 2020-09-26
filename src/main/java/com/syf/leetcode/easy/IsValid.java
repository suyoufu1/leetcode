package com.syf.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @auth syf
 * @date 2020/9/26 19:51
 * @des 有效的括号
 */
public class IsValid {
    public static void main(String[] args) {
        String s = "{[()]}";
        boolean valid = isValid2(s);
        System.out.println(valid);
    }
    public static boolean isValid(String s) {
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0 ; i < s.length() ; i ++){
            if(queue.isEmpty()){
                if(s.charAt(i) == '(' || s.charAt(i) == '{'
                || s.charAt(i) == '['){
                    queue.add(s.charAt(i));
                }else if(s.charAt(i) == ')' || s.charAt(i) == '}'
                        || s.charAt(i) == ']'){
                    return false;
                }
            }else {
                Character peek = queue.peek();
                if(peek == '(' && s.charAt(i) == ')'){
                    queue.poll();
                }else if(peek == '{' && s.charAt(i) == '}'){
                    queue.poll();
                }else if(peek == '[' && s.charAt(i) == ']'){
                    queue.poll();
                }else {
                    return false;
                }
            }
        }
        if(queue.isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean isValid2(String s){
        //1.特判
        if(s.isEmpty()) return true;
        //2.创建辅助栈
        Stack<Character> stack = new Stack<>();
        //3.遍历
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        //4.返回
        return stack.isEmpty();
    }

    public static boolean isValid3(String s){
        if(s.isEmpty()){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }
            if(c == '['){
                stack.push(']');
            }
            if(c == '{'){
                stack.push('}');
            }
            if(stack.isEmpty() || c != stack.pop()){
                return false ;
            }
        }
        return stack.isEmpty();
    }

}
