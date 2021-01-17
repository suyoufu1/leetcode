package com.syf.leetcode.backtracke;

import java.util.*;
import java.util.stream.Stream;

/**
 * @auth syf
 * @date 2021/1/17 20:53
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Set<List<Integer>> res = combinationSum(candidates,target);
        System.out.println(res);
    }
    public static Set<List<Integer>> res = new HashSet<>();
    private static Set<List<Integer>> combinationSum(int[] candidates, int target) {
       // 先对进行排序
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>() ;
        backTrack(list,target,candidates,0,0);
        return res ;
    }

    private static void  backTrack(List<Integer> list, int target,
                                                 int[] candidates, int sum, int begin) {
        // 出口
        if (target == sum){
            res.add(new ArrayList<>(list));
            return ;
        }

        for (int i = begin ; i < candidates.length ; i++){
            int rs = sum + candidates[i];
            if(rs <= target){
                list.add(candidates[i]);
                backTrack(list,target,candidates,rs,i+1);
                // 如果大于 target，则移除最后一个元素
                list.remove(list.size() - 1);
            }else {
                break;
            }
        }
    }
}
