package com.syf.leetcode.mid;

import java.util.*;

/**
 * @auth syf
 * @date 2020/9/21 18:33
 */
public class ThreeSum {
    /**
     *  三数之和
     *      给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     *      请你找出所有满足条件且不重复的三元组。
     *      注意：答案中不可以包含重复的三元组。
     * @param nums
     * a+b+c = 0  a = 0 - b - c
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        //排序+双指针
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i ++){
            //考虑重复情况
            if(i> 0 && nums[i] == nums[i-1]){
                continue;
            }
            int a = nums[i] ;
            int left = i + 1 ;
            int right = nums.length - 1 ;
            while (left < right){
                int temp = a + nums[left] + nums[right];
                if(temp == 0 ){
                    List<Integer> list = new ArrayList<>();
                    list.add(a);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    //考虑重复情况
                    while (left < right && nums[left] == nums[left+1]){
                        left ++;
                    }
                    while (left < right && nums[right] == nums[right -1]){
                        right -- ;
                    }
                    left ++ ;
                    right -- ;
                }else if(temp > 0){
                    right -- ;
                }else {
                    left ++ ;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}
