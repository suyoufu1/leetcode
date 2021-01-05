package com.syf.leetcode.binaryTree;

import javax.xml.soap.Node;

/**
 * @auth syf
 * @date 2020/10/14 18:08
 * 重建二叉树
 */
public class BuildTree {
    /**
     * 这里只要找到了前序遍历的结点在中序遍历的位置，我们就可以把中序遍历数组分解为两部分了。
     * 如果index是前序遍历的某个值在中序遍历数组中的索引，以index为根节点划分的话，那么中序遍历中
     *
     * [0，index-1]就是根节点左子树的所有节点，
     *
     * [index+1，inorder.length-1]就是根节点右子树的所有节点。
     *
     * 中序遍历好划分，那么前序遍历呢，如果是左子树：
     *
     * preStart=index+1；
     *
     * 如果是右子树就稍微麻烦点，
     *
     * preStart=preStart+(index-instart+1)；
     *
     * preStart是当前节点比如m先序遍历开始的位置，index-instart+1就是当前节点m左子树的数量加上当前节点的数量，
     * 所以preStart+(index-instart+1)就是当前节点m右子树前序遍历开始的位置，我们来看下完整代码
     */
    public NodeTree buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private NodeTree helper(int preStart, int isStart, int isEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length - 1 || isStart > isEnd){
            return null;
        }
        // 获取前序遍历的节点
        NodeTree root = new NodeTree(preorder[preStart]);
        int index = 0 ;
        for(int i = isStart ;i < isEnd ; i ++){
            // 找到中序遍历的根节点
            if(inorder[i] == root.val){
                index = i ;
                break;
            }
        }
        // 递归
        root.left = helper(preStart+1,index + isStart ,index , preorder,inorder);
        root.right = helper(preStart+index-isStart+1,index+1,isEnd,preorder,inorder);
        return root;
    }


}
