package com.qiyu.leetcode;

public class LeetCodeApplication {

    public static void main(String[] args) {
        Solution solution = new Solution();

        //竟然没考虑到负数
        System.out.println(solution.isPowerOfFour(-2147483648));
    }
}