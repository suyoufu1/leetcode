package com.syf.leetcode.tree;

/**
 * @auth syf
 * @date 2021/1/12 18:33
 * 判断两棵二叉树是否结构相同
 *      结构相同指的是 都有左子树和右子树
 *          递归来解决
 *
 */
public class IsBinarytreeEqual {
    public static void main(String[] args) {
        Node node1 = NodeInit.init();
        Node node2 = NodeInit.init();
        boolean flag = isBinarytreeEqual(node1,node2);
        System.out.println(flag);
    }

    private static boolean isBinarytreeEqual(Node node1, Node node2) {
        // 出口
        if(node1 == null && node2 == null){
            return true;
        }else if(node1 == null || node2 == null){
            return false ;
        }else {
            boolean leftFlag = isBinarytreeEqual(node1.left, node2.left);
            boolean rightFlag = isBinarytreeEqual(node1.right, node2.right);
            return (node1.x == node2.x) && leftFlag && rightFlag;
        }
    }
}
