package com.syf.leetcode.binaryTree;

/**
 * @auth syf
 * @date 2020/10/11 20:50
 * 二叉树的最大深度
 */
public class TreeDepth {
    public static  int depthTree(NodeTree root){
        if(root == null){
            return 0 ;
        }
        int left = depthTree(root.left);
        int right = depthTree(root.right);
        return Math.max(left,right) + 1 ;
    }
}
