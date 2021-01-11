package com.syf.leetcode.tree;

/**
 * @auth syf
 * @date 2021/1/10 11:39
 * 二叉树的深度
 */
public class TreeHigh {
    public static void main(String[] args) {
        Node root = new Node(2);
        int high =treeHigh(root);
        System.out.println(high);
    }

    private static int treeHigh(Node root) {
        if(root == null){
            return 0;
        }
        int left = treeHigh(root.left);
        int right = treeHigh(root.right);
        return Math.min(left,right)+1;
    }
}
