package com.syf.leetcode.tree;

/**
 * @auth syf
 * @date 2021/1/11 20:00
 */
public class NodeInit {
    public static Node init(){
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.right.left = new Node(8);
        root.right.right = new Node(4);
        return root;
    }
}
