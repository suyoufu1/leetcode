package com.syf.leetcode.stringType;

import java.util.LinkedList;
import java.util.List;

/**
 * 两个链表相加
 * 8 7 9
 * 2 1 4
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
       ListNode l1 = new ListNode(2);
       l1.next = new ListNode(4);
       l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = add2(l1, l2);
        while (listNode != null){
            System.out.println(listNode.x);
            listNode = listNode.next;
        }
        System.out.println(listNode);
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

    public static ListNode addTwo(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode phead = result ;
        int flag = 0 ;
        while (l1 != null && l2 != null ){
            int val = l1.x + l2.x + flag;
            flag = 0 ;//进位
            if(val >= 10){
                flag = 1 ;
                val = val % 10 ;
            }
            ListNode temp = new ListNode(val);
            phead.next = temp ;
            l1 = l1.next ;
            l2 = l2.next ;
            phead = phead.next ;
        }
        while (l1 != null){
            int val = l1.x + flag ;
            flag = 0 ;
            if(val >=  10){
                flag = 1 ;
                val = val % 10 ;
            }
            ListNode temp = new ListNode(val);
            phead.next = temp ;
            l1 = l1.next ;
            phead = phead.next ;
        }
        while (l2 != null){
            int val = l2.x + flag ;
            flag = 0 ;
            if(val >=  10){
                flag = 1 ;
                val = val % 10 ;
            }
            ListNode temp = new ListNode(val);
            phead.next = temp ;
            l2 = l2.next ;
            phead = phead.next ;
        }
        if(flag == 1){
            ListNode temp = new ListNode(1);
            phead.next = temp;
        }
        return result.next;
    }

     static class ListNode{
        Integer x ;
        ListNode next ;
        public ListNode(int x){
            this.x = x;
        }
    }

    public static ListNode add2(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode phead = result ;
        int flag = 0 ; // 进位
        while (l1 != null || l2 != null){
            int x = l1 != null ? l1.x : 0;
            int y = l2 != null ? l2.x : 0 ;
            int sum = x + y + flag ;
            flag = 0 ;
            if( sum > 9){
                flag = 1 ;
                sum = sum % 10 ;
            }
            phead .next = new ListNode(sum);
            phead = phead.next ;
            if(l1 != null){
                l1 = l1.next ;
            }
            if (l2 != null){
                l2 = l2.next;
            }

        }
        if(flag > 0){
            phead.next = new ListNode(flag);
        }
        return result.next ;
    }
}


