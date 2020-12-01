package com.syf.leetcode.binaryTree;

/**
 * @auth syf
 * @date 2020/10/12 21:39
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {
    /**
     *  思路：
     *      公共的祖先，分四种情况
     *      1）如果root为空则返回null
     *      2)如果p和q分别为root的左右子节点
     *      3）如果root左子树为空，怎返回right
     *      4）如果root右子树为空，则返回left
     * @param root
     * @param p
     * @param q
     * @return
     */
    public NodeTree lowestCommonAncestor(NodeTree root, NodeTree p, NodeTree q) {
        if(root == null || root.left == p || root.right == q){
            return root ;
        }
        NodeTree left = lowestCommonAncestor(root.left,p,q);
        NodeTree right = lowestCommonAncestor(root.right,p,q);
        if(left == null ){
            return right;
        }
        if(right == null){
            return left ;
        }
        return root ;
    }
}
