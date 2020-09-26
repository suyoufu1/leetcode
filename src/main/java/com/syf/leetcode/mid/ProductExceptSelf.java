package com.syf.leetcode.mid;

/**
 * @auth syf
 * @date 2020/9/26 16:02
 * @des 除自身以外数组的乘积
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf3(nums);
        for (int x : res){
            System.out.println(x);
        }
    }

    /**
     * 暴力法
     * @param nums
     * @return
     */
    private static int[] productExceptSelf(int[] nums) {
        //边界判断
        if(nums.length == 0){
            return nums;
        }
        int[] res = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i ++){
            res[i] = 1 ;
            for(int j = 0 ; j < nums.length ; j ++){
                if(j == i){
                    continue;
                }
                res[i] *= nums[j] ;
            }
        }
        return res;
    }

    /**
     * 时间复杂度O(n)
     * @param nums
     * @return
     */
    private static int[] productExceptSelf2(int[] nums) {
        //边界判断
        if(nums.length == 0){
            return nums;
        }
        int[] res = new int[nums.length];
        for(int i = 0 ; i < res.length ; i ++){
            res[i] = 1 ;
        }
        for(int i = 0 ,j = 0 ; i < nums.length && j < nums.length ;j++){
            if(j == i){
                continue;
            }
            res[i] *= nums[j];
            if(j == nums.length - 1){
                j = 0;
                i ++;
            }
        }
        return res;
    }

    private static int[] productExceptSelf3(int[] nums){
        //先计算左边，然后计算右边
        int k = 1 ;
        int[] res = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i ++){
            res[i] = k ;
            k *= nums[i] ;
        }
        k = 1 ;
        for(int i = nums.length - 1 ; i >= 0 ; i --){
            res[i] *= k;
            k *= nums[i] ;
        }
        return res;
    }
}
