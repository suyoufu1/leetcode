package com.syf.leetcode.binaryTree;

/**
 * @auth syf
 * @date 2020/10/11 20:29
 * 对称二叉树
 */
public class Symmetric {
    public Boolean isSymmetric(NodeTree root){
        return isSame(root,root);
    }

    private Boolean isSame(NodeTree t1, NodeTree t2) {
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false ;
        }
        return (t1.val == t2.val) &&
                isSame(t1.left , t2.right) &&
                isSame(t1.right, t2.left);
    }
}
