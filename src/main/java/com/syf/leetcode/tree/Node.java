package com.syf.leetcode.tree;

import lombok.NoArgsConstructor;

/**
 * @auth syf
 * @date 2021/1/10 11:35
 * 二叉树定义
 */
public class Node {
    int x ;
    Node left ;//左子树
    Node right ;//右子树
    public Node(int val){
        x = val ;
    }
}
