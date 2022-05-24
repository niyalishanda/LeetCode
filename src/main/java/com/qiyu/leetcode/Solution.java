package com.qiyu.leetcode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    
    /**
     * dp: dp[i]
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                //正好凑成一对
                //dp[i] = dp[i-2] + 2
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                //((...))的情况, 需要判断与当前)相对的位置
                //此时, 前面的肯定是合法的dp[i-1], 当前的index - dp[i-1] - 1就是需要判断的位置
                //除此之外, 如果再前面也是合法的, 即index - dp[i-1] - 1 - 1, 也需要添加进去
                //dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2
                else if(i - dp[i-1] >= 1 && s.charAt(i - dp[i-1] -1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i-1] >= 2 ? dp[i - dp[i-1] -2] : 0) + 2;
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 遍历一遍即可O(n)
     * * 如果是'('就push进去
     * * 如果是')'则进行pop处理, 如果栈为空, 表示没有匹配的括号, 此时将当前index添加到dq中, 表示最新没有匹配的位置
     * 如果栈不为空, 则可以通过peek栈顶, index - 栈顶得到与该右括号匹配的最长有效括号
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int length = s.length();
        int max = 0;
        Deque<Integer> dq = new LinkedList<>();
        dq.push(-1);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                dq.push(i);
            } else {
                dq.pop();
                if (dq.isEmpty()) {
                    dq.push(i);
                } else {
                    max = Math.max(max, i - dq.peek());
                }
            }
        }
        return max;
    }
}
