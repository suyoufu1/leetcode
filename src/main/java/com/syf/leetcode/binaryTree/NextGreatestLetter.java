package com.syf.leetcode.binaryTree;

import javax.print.attribute.standard.PresentationDirection;

/**
 * @ClassName
 * @Author syf
 * @Date 2021/1/9
 * @Version
 *  寻找比目标字母大的最小字母
 *      输入:
 *          letters = ["c", "f", "j"]
 *          target = "c"
 *      输出: "f"
 */
public class NextGreatestLetter {
    public static void main(String[] args) {
        char[] strs = {'c','f','j'};
        char target = 'd' ;
        char ch = nextGreatestLetter(strs,target);
        System.out.println (ch);
    }

    private static char nextGreatestLetter(char[] strs, char target) {

        int l = 0 , r = strs.length - 1 ;
        // 字符串是有序的
        while (l <= r){
            int mid = l + (r - l)/2 ;
            if(strs[r] < target){
                break;
            }
            if(strs[mid] < target){
                l = mid + 1;
            }else if(strs[mid] > target){
                r = mid - 1;
            }
        }
        return r+1 < strs.length + 1 ? strs[r+1] : strs[0]  ;
    }
    private static char nextGreatestLetter2(char[] strs, char target) {

        for (char c : strs){
            if(c > target){
                return c ;
            }
        }
        return strs[0] ;
    }
}
