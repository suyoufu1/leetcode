package com.syf.leetcode.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @auth syf
 * @date 2020/9/20 19:16
 *  二叉树的层序遍历
 *      给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）
 */
public class LevelOrder{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        levelOrder(root);
    }

    /**
     * 利用算法 ： 广度优先搜索算法 (BFS)
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        List<List<Integer>> res = new ArrayList<>();
        //初始化队列
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队列
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            //每一层的大小
            int count = queue.size();
            for(int i = 0 ; i < count ; i ++) {
                //去除当前的元素
                TreeNode current = queue.poll();
                level.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            res.add(level);
        }
        return res ;
    }

    /**
     * 定义二叉树结点
     */
    public static class TreeNode{
        int val ;
        TreeNode left ;
        TreeNode right ;
        public TreeNode(int x){
            val = x ;
        }

    }
}
