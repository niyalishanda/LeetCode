package com.qiyu.leetcode;

public class LeetCodeApplication {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        solution.maxSlidingWindow(nums, 3);
    }
}