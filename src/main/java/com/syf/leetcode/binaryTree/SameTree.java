package com.syf.leetcode.binaryTree;

/**
 * @auth syf
 * @date 2020/10/11 17:34
 *  相同的树
 */
public class SameTree {
    public Boolean isSameTree(NodeTree p , NodeTree q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false ;
        }
        if(p.val != q.val){
            return false;
        }
        return (p.left.val == q.left.val) &&
                (p.right.val == q.right.val);
    }
}
