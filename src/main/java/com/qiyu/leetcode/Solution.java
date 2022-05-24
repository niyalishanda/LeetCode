package com.qiyu.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {


    /**
     * 优先级队列, 大顶堆
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; i++) {
            pq.add(new int[] {nums[i], i});
        }

        int[] ans = new int[nums.length - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < nums.length; i++) {
            pq.add(new int[] {nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    /**
     * 单调队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();

        //初始化第一个滑动窗口
        for(int i = 0; i < k; i++) {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        int[] ans = new int[nums.length - k + 1];
        //第一个滑动窗口的值
        ans[0] = nums[dq.peekFirst()];
        for(int i = k; i < nums.length; i++) {
            //移除所有比当前小的值, 保持单调性
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            //如果值超过k个, 则需要进行移除
            if(dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            ans[i - k + 1] = nums[dq.peekFirst()];
        }
        return ans;
    }
}
