package com.qiyu.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < k; i++) {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[dq.peekFirst()];
        for(int i = k; i < nums.length; i++) {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            if(dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            ans[i - k + 1] = nums[dq.peekFirst()];
        }
        return ans;
    }
}
