package com.syf.leetcode.backtracke;

import java.util.ArrayList;
import java.util.List;

/**
 * @auth syf
 * @date 2021/1/17 22:13
 * 全排列
 */
public class Permute {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        res = permute(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> permute(int[] nums) {
        permute(nums,new ArrayList<>());
        return res;
    }

    private static  void permute(int[] nums, List<Integer> list) {
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0 ; i < nums.length ; i ++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            permute(nums,list);
            list.remove(list.size()-1);
        }
    }
}
