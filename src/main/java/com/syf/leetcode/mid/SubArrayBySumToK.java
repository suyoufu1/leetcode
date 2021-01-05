package com.syf.leetcode.mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @auth syf
 * @date 2020/12/1 20:40
 */
public class SubArrayBySumToK {
    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     */
    public static void main(String[] args) {
        int[] nums = {1,-1,0};
        int k = 0 ;
        int count = subarraySum(nums, k);
        System.out.println(count);
    }
    public static int subarraySum(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        // 先对数组进行排序

        // 进行求和，遍历->连续相加等于目标数
        int i = 0 ;
        int j = 1 ;
        int count = 0 ;
        if(nums.length == 1){
            if(nums[0] == k){
                return 1;
            }
        }
        while (i < nums.length && j < nums.length){
            if(nums[i] == k || nums[j] == k){
                count ++ ;
                break;
            }else {
                int temp = nums[i] + nums[j] ;
                if (temp == k && j - i == 1) {
                    count++;
                    i++;
                    j++;
                } else if (temp < k) {
                    i++;
                    j++;
                } else {
                    break;
                }
            }
        }
        return count ;
    }
    public int KSum(int[] nums, int k){
        int pre = 0 ;
        int count = 0 ;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0 ; i < nums.length ; i ++){
            pre += nums[i] ;
            if(map.containsKey(pre - k)){
                count += map.get(pre-k);
            }
            // getOrDefault() 先根据key获取value的值，如果么有则用默认值
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count ;
    }
}
