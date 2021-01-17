package com.syf.leetcode.tree;

import sun.awt.geom.AreaOp;

/**
 * @auth syf
 * @date 2021/1/11 19:56
 *
 * 求二叉树第K层的节点个数
 */
public class KNodeNum {
    //这里的k层的节点个数就是k-1层的子节点
    public static void main(String[] args) {
        Node root = NodeInit.init();
        int k = 3 ;
        int num = kNodeNum(root , k );
        System.out.println(num);
    }

    private static int kNodeNum(Node root, int k) {
        if (root == null || k < 1){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        int leftNum = kNodeNum(root.left, k-1);
        int rightNum = kNodeNum(root.right, k - 1);
        return rightNum + leftNum ;
    }
    // 非递归怎么解决

    /**
     * 怎么样的思路
     *      是不是有点类似于 层序遍历
     *          队列解决
     * @param root
     * @param k
     * @return
     */
    /*private static int kNodeNum2(Node root, int k) {
        if (root == null || k < 1){
            return 0;
        }
        if (k == 1){
            return 1;
        }
    }*/


}
