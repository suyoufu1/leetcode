package com.syf.leetcode.binaryTree;

/**
 * @ClassName
 * @Author syf
 * @Date 2021/1/9
 * @Version
 * 有序数组中的单一元素
 */
public class SingleNonDuplicate {
    public static void main(String[] args) {
        int[] nums = {};
        int sing = singleNonDuplicate(nums);
        System.out.println (sing);
    }

    private static int singleNonDuplicate(int[] nums) {
        if (nums.length <= 0 ){
            return -1 ;
        }
        // 利用二分法来解决
        int l = 0 ,  r = nums.length - 1 ;
        while (l < r){
            int mid = l + (r-l)/2 ;
            //  判断是奇数还是偶数
            boolean flag = (r - mid) % 2 == 0 ;
            if(nums[mid+1] == nums[mid]){
                if(flag){
                    l = mid + 2 ;
                }else {
                    r = mid - 1 ;
                }
            }else if(nums[mid-1] == nums[mid]){
                if(flag){
                    r = mid - 2 ;
                }else {
                    l = mid + 1 ;
                }
            }else {
                return nums[mid] ;
            }
        }
        return nums[l];
    }

    private static int singleNonDuplicate2(int[] nums) {
        if (nums.length <= 0 ){
            return -1 ;
        }
        for (int i = 0 ; i < nums.length-1 ; i +=2){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
