package com.syf.leetcode.tree;

/**
 * @auth syf
 * @date 2021/1/10 11:34
 * 求二叉树的节点个数
 */
public class NodeCount {
    public static void main(String[] args) {
        Node root = new Node(1);
        int sum = nodeCount(root);
        System.out.println(sum);
    }

    private static int nodeCount(Node root) {
        if(root == null){
            return 0;
        }else {
            return nodeCount(root.left)+nodeCount(root.right)+1 ;
        }
    }
}
