package com.syf.leetcode.binaryTree;

/**
 * @auth syf
 * @date 2020/10/11 20:58
 *  平衡二叉树
 */
public class Balanced {
    public Boolean isBalanced(NodeTree root){
        if(root == null){
            return true;
        }
        if(Math.abs((getDepth(root.left) - getDepth(root.left))) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getDepth(NodeTree root) {
        if(root == null){
            return 0 ;
        }
        return Math.max(getDepth(root.left),getDepth(root.right)) + 1;
    }
}
