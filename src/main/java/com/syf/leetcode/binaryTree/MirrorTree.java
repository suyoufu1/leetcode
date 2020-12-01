package com.syf.leetcode.binaryTree;

/**
 * @auth syf
 * @date 2020/10/11 21:30
 *
 */
public class MirrorTree {
    public NodeTree mirrorTree(NodeTree root){
        if (root == null){
            return null;
        }
        NodeTree temp = root.left ;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root ;
    }
}
