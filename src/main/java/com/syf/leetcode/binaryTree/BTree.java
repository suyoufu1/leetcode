package com.syf.leetcode.binaryTree;

import java.util.List;
import java.util.Stack;

/**
 * @auth syf
 * @date 2020/10/11 17:13
 */
public class BTree {
    /**
     * 递归
     * @param root
     */
    public void traverse(NodeTree root){
        if(root == null){
            return;
        }
        traverse(root.left);
        traverse(root.right);
    }
    /**
     * 非递归-》队列或者栈
     */
    public void treeB(NodeTree root){
        if(root == null){
            return;
        }
        Stack<NodeTree> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            NodeTree temp = stack.pop();
            if(temp.left != null){
                stack.push(temp.left);
            }
            if(temp.right != null){
                stack.push(temp.right);
            }
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(NodeTree root, List<Integer> res){
        if(root != null) {
            res.add(root.val);
            preOrder(root.left,res);
            preOrder(root.right,res);
        }
    }
    /**
     * 中序遍历
     * @param root
     * @param res
     */
    public void inOrder(NodeTree root, List<Integer> res){
        if(root != null) {
            preOrder(root.left,res);
            res.add(root.val);
            preOrder(root.right,res);
        }
    }
    /**
     * 后续遍历
     * @param root
     * @param res
     */
    public void postOrder(NodeTree root, List<Integer> res){
        if(root != null) {
            preOrder(root.left,res);
            preOrder(root.right,res);
            res.add(root.val);
        }
    }
}

/**
 * 定义二叉树节点
 */
class NodeTree{
    int val ;
    NodeTree left ;
    NodeTree right ;
    public NodeTree(int val){
        this.val = val ;
    }
}