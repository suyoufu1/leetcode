package com.syf.leetcode.binaryTree;

import io.netty.handler.codec.dns.DnsQuery;

import java.util.*;

/**
 * @auth syf
 * @date 2020/10/14 15:02
 * 从上到下打印二叉树2
 */
public class LevelOrder2 {
    /**
     * 用广度优先遍历算法BFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(NodeTree root) {
        if(root == null){
            return new ArrayList();
        }
        List<List<Integer>> res = new ArrayList();
        // 利用栈来存储
        Queue<NodeTree> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList();
            for(int i = 0 ; i < queue.size() ; i ++ ){
                NodeTree nodeTree = queue.poll();
                list.add(nodeTree.val);
                if(nodeTree.left != null){
                    queue.add(nodeTree.left);
                }
                if (nodeTree.right != null){
                    queue.add(nodeTree.right) ;
                }
            }
            res.add(list);
        }
        return res;
    }
}
