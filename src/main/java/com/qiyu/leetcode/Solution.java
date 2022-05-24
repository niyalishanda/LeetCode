package com.qiyu.leetcode;

import java.util.Stack;

class Solution {

    /**
     * 动态规划
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int length = height.length;
        if(length <= 1) {
            return 0;
        }

        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for(int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        int sum = 0;
        for(int i = length - 2; i >= 0 ; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }


    /**
     * 最快
     *  ans += leftMax - height[left];这个隐含了条件 rightMax >= leftMax
     *  height[right]
     *  height[left]
     *  height[left] < height[right]
     *
     *  jrightMax <= irightMax
     *  ileftMax >= jleftMax
     *
     *  现在我们只计算ileftMax和jrightMax
     *  在height[left] < height[right]的情况下
     *  我们将leftMax - height[left]作为可以接的雨水, 此时隐含了 rightMax > leftMax, 即jRightMax > iLeftMax
     *  因为jRightMax小于等于iRightMax, 所以可以得出结论iRightMax > iLeftMax
     */
    public int trap2(int[] height) {
        int length = height.length;
        int sum = 0;
        int left = 0;
        int right = length - 1;
        int maxLeft = 0, maxRight = 0;
        while(left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if(maxLeft < maxRight) {
                sum += maxLeft - height[left];
                left++;
            } else {
                sum += maxRight - height[right];
                right--;
            }
        }

        return sum;
    }

    /**
     * 最慢
     * 单调栈
     * @return
     */
    public int trap3(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer top = stack.pop();
                //左边没有了, 接不住雨水
                if (stack.isEmpty()) {
                    break;
                }

                Integer left = stack.peek();
                int width = i - left - 1;
                int h = Math.min(height[i], height[left]) - height[top];

                sum += h * width;
            }
            stack.push(i);
        }
       return sum;
    }
}
