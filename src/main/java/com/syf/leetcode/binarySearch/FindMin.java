package com.syf.leetcode.binarySearch;

import com.sun.org.apache.xerces.internal.impl.dtd.models.CMUniOp;

/**
 * @ClassName
 * @Author syf
 * @Date 2021/1/9
 * @Version
 *
 * 寻找旋转排序数组中的最小值
 */
public class FindMin {
    public static void main(String[] args) {
        int[] nums = {} ;
        int min = findMin(nums);
    }

    private static int findMin(int[] nums) {
        if(nums.length == 0){
            return -1;
        }

        int l = 0 , r = nums.length - 1 ;

        while (l <= r){
            int mid = l + (r - l)/2 ;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid] < nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid] > nums[0]){
                l = mid + 1 ;
            }else {
                r = mid ;
            }
            /*if (nums[mid] > nums[r]){
                l = mid + 1 ;
            }else if (nums[mid] < nums[l]){
                // mid有可能是最小的值
                r = mid ;
            }else if(nums[mid] == nums[r] ){
                r -- ;
            }else { // 升序
                return nums[l] ;
            }
            mid = l + (r - l)/2 ;*/
        }
        return -1;

    }
}
