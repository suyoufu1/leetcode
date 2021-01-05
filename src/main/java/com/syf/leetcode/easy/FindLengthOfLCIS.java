package com.syf.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auth syf
 * @date 2020/9/28 21:00
 * @des 最长连续递增序列
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int len = findLengthOfLCIS(nums);
        System.out.println(len);
    }
    public static  int findLengthOfLCIS(int[] nums){
        if(nums.length <= 1){
            return nums.length;
        }
        //定义一个变量统计最大长度，用计数器来实现
        int maxLen = 1 ;
        int count = 1 ;
        int temp = nums[0];
        for(int i = 1 ; i < nums.length ; i ++ ){
            if(i > 0 && nums[i] > nums[i-1]){
                count ++;
                temp = nums[i] ;
            }else {
                count = 1 ;
                temp = nums[i] ;
            }
            maxLen = maxLen > count ? maxLen : count ;
        }
        return maxLen;
    }

    public int frame(int[] param){
        int count = 1  , maxCount = 1 , temp = param[0];
        for(int i = 1 ; i < param.length ; i ++){
            if(i > 0 && param[i] > param[i-1]){
                count += 1 ;
                temp = param[i] ;
            } else {
                count = 1 ;
                temp = param[i] ;
            }
            maxCount = maxCount > count ? maxCount : count ;
        }
        return maxCount ;
    }
    public int findLengthOfLCIS2(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int res = 0 ;
        int temp = 0 ;
        List<Integer> list = new ArrayList();
        boolean flag = true;
        for(int i = 0 ; i < nums.length-1 ; i ++){
            int j = i + 1 ;
            if(nums[i] < nums[j]){
                temp++;
                flag = true;
            }else{
                flag = false;
            }
            if(!flag){
                list.add(temp+1);
                temp = 0;
            }
            if(j == nums.length-1){
                list.add(temp+1);
            }
        }
        if(list.size() == 0){
            return 1;
        }
        Collections.sort(list);
        res = list.get(list.size()-1);
        return res;
    }
}
