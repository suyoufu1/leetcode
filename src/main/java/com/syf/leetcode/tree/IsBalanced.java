package com.syf.leetcode.tree;

/**
 * @auth syf
 * @date 2021/1/11 20:38
 *  判断一棵树是否是平衡二叉树
 */
public class IsBalanced {
    public static void main(String[] args) {
        Node node = NodeInit.init();
        boolean isB = isBalanced(node);
        System.out.println(isB);
    }
    private static boolean isBalanced(Node node) {
        // 出口
        if (node == null){
            return true;
        }
        // 平衡树 左子树 - 右子树 《= 1
        int leftD= depth(node.left);
        int rightD = depth(node.right);
        boolean flag = Math.abs(leftD - rightD) <= 1 ? true : false ;
        return flag && isBalanced(node.left) && isBalanced(node.right);
    }
    private static int depth(Node root) {
        if(root == null){
            return 0;
        }
        depth(root.left);
        depth(root.right);
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}
