package com.qiyu.leetcode;

class Solution {
    public void exec() {
        firstMissingPositive2(new int[]{3,4,-1,1});
    }

    public int firstMissingPositive2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        //进行处理, abs的原理, 此时被置为负数的位置也需要进行判断
        //3,4,-1,1中的4和1
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public int firstMissingPositive(int[] nums) {
        //置换
        for(int i = 0; i < nums.length; i++) {
            //此处需要用while, 原因是换过来的数字可能仍然需要进行置换
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i);
            }
        }

        //遍历第一个正数
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private void swap(int[] nums, int i) {
        int num = nums[i];
        nums[i] = nums[num - 1];
        nums[num - 1] = num;
    }
}
