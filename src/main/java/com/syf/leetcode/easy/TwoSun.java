package com.syf.leetcode.easy;

import java.util.*;

/**
 * @auth syf
 * @date 2020/12/1 16:16
 */
public class TwoSun {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，
     *  请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *  给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     */
    public static int[] twoSum(int[] nums, int target) {
        // 双指针
        int i = 0 ;
        int j = nums.length-1 ;
        int[] res = new int[2];
        while (i <  j ){
            int temp = nums[i] + nums[j];
            if( temp == target){
                res[0] = nums[i];
                res[1] = nums[j];
                break;
            }else if(temp > target){
                j -- ;
            }else {
                i ++ ;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums ={2, 7, 11, 15};
        int target = 9 ;
        int[] ints = twoSum(nums, target);
        System.out.println(ints);
    }

    /**
     * 哈希
     * @param nums
     * @param target
     * @return
     */
    public static  int[] twoSumHash(int[] nums ,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
