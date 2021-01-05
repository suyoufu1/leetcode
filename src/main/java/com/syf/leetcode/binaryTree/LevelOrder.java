package com.syf.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @auth syf
 * @date 2020/10/14 15:02
 * 从上到下打印二叉树
 */
public class LevelOrder {
    /**
     * 用广度优先遍历算法BFS
     * @param root
     * @return
     */
    public int[] levelOrder(NodeTree root) {
        if(root == null){
            return new int[0];
        }
        // 定义一个队列
        Queue<NodeTree> queue = new LinkedList<>();
        // 定义一个list集合
        List<Integer> list = new ArrayList<>();
        // 将根节点放入队列
        queue.offer(root);
        // 进行遍历
        while (!queue.isEmpty()){
            // 取当前节点
            NodeTree poll = queue.poll();
            list.add(poll.val);
            // 判断当前取出的节点是否有左右子树
            if(poll.left != null){
                queue.offer(poll.left);
            }
            if (poll.right != null){
                queue.offer(poll.right);
            }
        }
        // 将集合转化为数组
        int[] res = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i ++){
            res[i] = list.get(i);
        }
        return res ;
    }
}
