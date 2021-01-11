package com.syf.leetcode.tree;

import java.util.Stack;

/**
 * @auth syf
 * @date 2021/1/10 11:43
 * 前序 中序 后序 遍历
 */
public class PreOrder {
    public static void main(String[] args) {
        Node root = new Node(2) ;
        preOrder(root);
    }

    private static void preOrder(Node root) {
        if(root != null){
            System.out.println(root.x);
            preOrder(root.left);
            preOrder(root.right);
        }else {
            return;
        }
    }
    private static void onOrder(Node root) {
        if(root != null){
            preOrder(root.left);
            System.out.println(root.x);
            preOrder(root.right);
        }else {
            return;
        }
    }

    private static void postOrder(Node root) {
        if(root != null){
            preOrder(root.left);
            preOrder(root.right);
            System.out.println(root.x);
        }else {
            return;
        }
    }


    // 非递归的方法实现
    private static void onOrder2(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack();
        Node p = root ;
        stack.push(p);
        while (!stack.isEmpty()){
           // 中序遍历
            // 左子树先入栈
            if (p != null && p.left != null){
               stack.push(p.left);
               p = p.left ;
            }else {
               p = stack.pop();
               System.out.println(p.x);
               if (p != null && p.right != null){
                   stack.push(p.right);
                   p = p.right;
               }else {
                   p = null;
               }
            }
        }
    }

    private static void preOrder2(Node root) {
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            // 出栈
            Node cur = stack.pop();
            System.out.println(cur.x);
            // 判断出栈的元素是否有左右子树
            // 如果有，先让右子树入栈，因为栈的特点是先进先出
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }
}
