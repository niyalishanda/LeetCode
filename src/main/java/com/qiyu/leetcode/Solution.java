package com.qiyu.leetcode;

import java.util.*;

class Solution {
    public void exec() {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        boolean isOrderLeft = true;

        while (!queue.isEmpty()) {
            Deque<Integer> levelResult = new LinkedList<>();

            for (int i = 0; i < queue.size(); i++) {
                TreeNode currNode = queue.poll();
                if (isOrderLeft) {
                    levelResult.offerLast(currNode.val);
                } else {
                    levelResult.offerFirst(currNode.val);
                }

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }

            result.add(new LinkedList<>(levelResult));
            isOrderLeft = !isOrderLeft;
        }

        return result;
    }
}
