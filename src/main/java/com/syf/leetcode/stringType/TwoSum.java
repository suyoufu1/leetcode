package com.syf.leetcode.stringType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syf on 2020/8/24
 * 两数之和:
 *  给定一个整数数组，返回两个数字的索引，以便它们加起来成为一个特定的目标。
 *  您可以假设每个输入都只有一个解决方案，并且您可能不会两次使用同一元素。
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,7};
        int target = 5;
        List<List<Integer>> lists = twoSum (nums, target);
        System.out.println ("lists = " + lists);
    }
    private static List<List<Integer>> twoSum(int[] nums , int target){
        List<List<Integer>> result = new ArrayList<> ();
        int len = nums.length - 1 ;
        for(int i = 0 ; i <= len ; i ++){
            for(int j = i + 1 ; j <= len ; j ++){
                if(target == nums[i] + nums[j]){
                    List<Integer> list = new ArrayList<> ();
                    list.add (i);
                    list.add (j);
                    result.add (list);
                }
            }
        }
        return result;
    }
}
