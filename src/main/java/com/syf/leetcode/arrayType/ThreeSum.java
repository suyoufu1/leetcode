package com.syf.leetcode.arrayType;

/**
 * Created by syf on 2020/8/24
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数字，三数之和为零，把这个三个数放到集合中，并且不重复
 * 思路：
 *  排序+双指针
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] num = {-1,1,0,2,3,-4};
        List<List<Integer>> lists = threeSum (num);
        System.out.println ("lists = " + lists);
    }
    public static  List<List<Integer>>  threeSum(int[] num){
        //1.排序
        Arrays.sort (num);
        List<List<Integer>> resultList = new ArrayList<> ();
        for(int i = 0 ; i < num.length ; i ++){
            if(num[i] > 0 ) {
                return resultList;
            }
            //2.防止重复
            if(i > 0 && num[i-1] == num[i]) {
                continue;
            }
            // 3.定义双指针
            int left = i+1;
            int right = num.length - 1 ;
            while (left < right){
                int temp = num[i] + num[left] + num[right];
                if(temp == 0){
                    List<Integer> list = new ArrayList<> ();
                    list.add (num[i]);
                    list.add (num[left]);
                    list.add (num[right]);
                    resultList.add (list);
                    //防止重复
                    while (left < right && num[left] == num[left+1]){ left ++;}
                    while (left < right && num[right] == num[right-1]){ right --;}
                    left ++ ;
                    right -- ;
                }else if(temp < 0){
                    left ++ ;
                }else {
                    right -- ;
                }
            }
        }
        return resultList;
    }
}
