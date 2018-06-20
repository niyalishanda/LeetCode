package com.qiyu.leetcode;


public class LeetCodeApplication {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isBalanced(TreeNodeCreator.stringToTreeNode("[3,9,20,null,null,15,7]")));
        System.out.println(solution.isBalanced(TreeNodeCreator.stringToTreeNode("[1,2,2,3,3,null,null,4,4]")));
        System.out.println(solution.isBalanced(TreeNodeCreator.stringToTreeNode("[1,2,2,3,null,null,3,4,null,null,4]")));
    }
}