package com.syf.leetcode.tree;

import java.util.Stack;

/**
 * @auth syf
 * @date 2021/1/12 18:41
 * 二叉树翻转(二叉树镜像)
 */
public class Mirror {
    public static void main(String[] args) {
        Node node = NodeInit.init();
        System.out.println(node.left.x);
        Node res = mirror(node);
        System.out.println(res.left.x);
    }

    private static Node mirror(Node node) {
        if(node == null){
            return  null;
        }
        Node temp = node.left ;
        node.left = node.right ;
        node.right = temp ;
        mirror(node.left);
        mirror(node.right);
        return node;
    }
    /**
     * 利用栈来实现-->怎么实现呢
     *      dfs ---> 先将根节点入栈，然后判断栈是否为空，如果不为空，则将栈顶元素出栈
     *               然后再将左子节点和右子节点交换 ，判断左右子节点是否存中，如果存在则
     *               入栈，同理操作
     */
    public static Node mirror2(Node node){
        if(node == null ){
            return null ;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node root = stack.pop();
            Node left = root.left;
            // 交换位置
            node.left = node.right ;
            node.right = left ;
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        return node ;
    }


}
