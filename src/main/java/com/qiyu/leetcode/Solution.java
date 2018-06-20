package com.qiyu.leetcode;


public class Solution {

    /**
     * Given a binary tree, determine if it is height-balanced.
     *
     * For this problem, a height-balanced binary tree is defined as:
     *
     * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     * Example 1:
     *
     * Given the following tree [3,9,20,null,null,15,7]:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * Return true.
     *
     * Example 2:
     *
     * Given the following tree [1,2,2,3,3,null,null,4,4]:
     *
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * Return false.
     */

    public int depth(TreeNode node) {
        if (node == null) return 0;

        int left = 1 + this.depth(node.left);
        int right = 1 + this.depth(node.right);

        return left > right ? left : right;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int left = this.depth(root.left);
        int right = this.depth(root.right);

        int distance = Math.abs(left - right);
        if(distance > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
