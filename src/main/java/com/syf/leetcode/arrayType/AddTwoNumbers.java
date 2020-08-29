package com.syf.leetcode.arrayType;

import java.util.LinkedList;
import java.util.List;

/**
 * 两个链表相加
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        List<Integer> listOne = new LinkedList<>();
        listOne.add(2);
        listOne.add(4);
        listOne.add(3);
        List<Integer> listTwo = new LinkedList<>();
        listTwo.add(5);
        listTwo.add(6);
        listTwo.add(4);
        List<Integer> add = add(listOne, listTwo);
        System.out.println("add = " + add);
        System.out.println("10%10 = " + 10%10);

    }
    public static List<Integer> add(List<Integer> listOne,List<Integer> listTwo){
        int flag = 0 ;
        List<Integer> result = new LinkedList<>();
        int i = listOne.size()-1 , j = listTwo.size()-1 ;
        for( ;i >= 0 && j >= 0 ; i -- , j --){
            int addT = listOne.get(i) + listTwo.get(j)+flag;
            if(addT >= 10){
                flag = 1 ;
                int temp = addT%10;
                result.add(temp);
            }else {
                result.add(addT);
            }
        }
        while (i >= 0){
            result.add(listOne.get(i));
        }
        while (j >= 0){
            result.add(listTwo.get(j));
        }
        return result;
    }

}


