package com.syf.leetcode.tree;

import java.util.*;

/**
 * @auth syf
 * @date 2021/1/12 20:47
 * 二叉树的右视图
 */
public class RightSideView {
    public static void main(String[] args) {
        Node node = NodeInit.init();
        List<Integer> list = rightSideView(node);
        System.out.println(list);

    }

    private static List<Integer> rightSideView(Node node) {
        if (node == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<Node> stack = new LinkedList<>();
        stack.add(node);
        while (!stack.isEmpty()){
            int count = stack.size();
            while (count > 0){
                Node pop = stack.poll();
                if (count == 1){
                    res.add(pop.x);
                }
                if (pop.left != null){
                    stack.add(pop.left);
                }
                if (pop.right != null){
                    stack.add(pop.right);
                }
                count -- ;
            }
        }
        return res;
    }
}
