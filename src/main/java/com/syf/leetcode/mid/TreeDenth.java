package com.syf.leetcode.mid;

/**
 * @auth syf
 * @date 2020/9/27 18:30
 * @des 给出一个二叉树，获取任意最长分支上的节点列表
 */
public class TreeDenth {
    public static void main(String[] args) {

    }
    /**
     * 先求出最深的长度，然后用栈来遍历，用深度函数来比较最大的入栈即可
     * static LinkedList<TreeNode> result;
     *  static void LongPath(TreeNode root, LinkedList<TreeNode> list, int sum, int max) {
     *         list.push(root);
     *         sum += root.val;
     *         if (null == root.right && null == root.left){
     *             if (max < sum) {
     *                 result = new LinkedList<>(list);
     *                 max = sum;
     *             }
     *         }
     *
     *         if (root.left != null)
     *             LongPath(root.left, list, sum, max);
     *         if (root.right != null)
     *             LongPath(root.right, list, sum, max);
     *         list.pop();
     *     }
     */
}
