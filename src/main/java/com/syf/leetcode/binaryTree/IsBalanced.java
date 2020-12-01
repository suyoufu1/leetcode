package com.syf.leetcode.binaryTree;

/**
 * @auth syf
 * @date 2020/10/14 22:34
 *  平衡二叉树
 */
public class IsBalanced {
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 第一种用递归
     * 第二种用深度优先遍历
     * 第三种用广度优先遍历
     */
    public boolean isBalanced(NodeTree root) {
        if(root == null){
            return true;
        }
        // 判断左右子树高度是否大于1
        if(Math.abs(getDepth(root.left) - getDepth(root.right)) > 1){
            return false;
        }
        // 递归左右子树的各个高度
        isBalanced(root.left);
        isBalanced(root.right);
        return true;
    }

    private int getDepth(NodeTree root) {
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.max(left,right)+1;
    }

    public boolean isBalanced2(NodeTree root) {
       return height(root) >= 0;
    }

    private int height(NodeTree root) {
        if (root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(right == -1 || left == -1 || Math.abs(left - right) > 1){
            return -1;
        }else {
            return Math.max(left,right)+1;
        }
    }

}
