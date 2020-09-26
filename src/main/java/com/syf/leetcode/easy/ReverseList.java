package com.syf.leetcode.easy;

/**
 * @auth syf
 * @date 2020/9/26 16:48
 * @des 反转链表
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        reverseList(listNode);
    }

    /**
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null ;
        while (cur != null){
            ListNode temp = cur.next ;
            cur.next = pre ;
            pre = cur ;
            cur = temp ;
        }
        return pre ;
    }

    public static ListNode reverseList2(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if(head == null || head.next == null){
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList2(head);
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head ;
        //防止链表循环，需要将head.next设置为空
        head.next = null ;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
