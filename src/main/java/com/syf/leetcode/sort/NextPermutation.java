package com.syf.leetcode.sort;

import java.util.Arrays;

/**
 * @auth syf
 * @date 2020/9/23 12:50
 * @des 下一个排列
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,3,2 };
        nextPermutation(nums);
        System.out.println(nums);
        for (int x : nums){
            System.out.print(x + ",");
        }
    }

    /**
     * 思路：直接从右边开始遍历，如果是逆序的话，一直遍历到当前比相邻的值大时交换位置
     * @param nums
     */
    private static void nextPermutation(int[] nums) {
        int i = nums.length - 2 ;
        while (i >= 0 && nums[i] >= nums[i+1]){
            i --;
        }
        //证明是全是降序排列
        if(i < 0) {
            Arrays.sort(nums);
            return;
        }
        int j = nums.length - 1 ;
        while (j >= 0 && nums[j] <= nums[i]) {
            j -- ;
        }
        swap(nums,i,j);

        }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }
}

