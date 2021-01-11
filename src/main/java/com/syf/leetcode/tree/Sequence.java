package com.syf.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @auth syf
 * @date 2021/1/11 19:27
 */
public class Sequence {
    // 层序遍历
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        root.left.left = new Node(0);
        root.right.right = new Node(4);
        sequence2(root);
    }

    private static void sequence(Node root) {
        if(root == null){
            return;
        }
        // 定义队列 先进先出
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        // 根先入队
        while (!queue.isEmpty()){
            Node node = queue.poll();;
            System.out.println(node.x);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }

    private static void sequence2(Node root) {
        if(root == null){
            return;
        }
        List<List<Integer>> res = new ArrayList<>();
        // 定义队列 先进先出
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        // 根先入队
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            // count记录根有多少个叶子节点
            while (count > 0){
                Node node = queue.poll();
                list.add(node.x);
                if(node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                count -- ;
            }
            res.add(list);
        }
        System.out.println(res);
    }
}
