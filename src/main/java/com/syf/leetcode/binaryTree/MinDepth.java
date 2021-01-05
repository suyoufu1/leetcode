package com.syf.leetcode.binaryTree;

/**
 * @auth syf
 * @date 2020/10/11 20:54
 */
public class MinDepth {
    public static  int depthTree(NodeTree root){
        if(root == null){
            return 0 ;
        }
        int left = depthTree(root.left);
        int right = depthTree(root.right);
        return Math.min(left,right) + 1 ;
    }
}
