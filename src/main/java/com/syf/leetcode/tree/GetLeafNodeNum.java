package com.syf.leetcode.tree;

/**
 * @auth syf
 * @date 2021/1/11 20:26
 * 求二叉树中叶子节点的个数
 */
public class GetLeafNodeNum {
    public static void main(String[] args) {
        Node root = NodeInit.init();
        int num = getLeafNodeNum(root);
        System.out.println(num);
    }

    private static int getLeafNodeNum(Node root) {
        if (root == null){
            return 0 ;
        }
        if(root.left == null && root.right == null){
            return 1 ;
        }
        int leftNum = getLeafNodeNum(root.left);
        int rightNum = getLeafNodeNum(root.right);
        return rightNum+leftNum;
    }
}
