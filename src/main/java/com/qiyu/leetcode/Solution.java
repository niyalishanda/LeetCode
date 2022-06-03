package com.qiyu.leetcode;

class Solution {
    public void exec() {
        findMedianSortedArrays(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22}, new int[] {0, 6});
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if(n % 2 == 0) {
            double left = find(nums1, 0, nums2, 0, n / 2);
            double right = find(nums1, 0, nums2, 0, n / 2 + 1);
            return (left + right) / 2.0;
        } else {
            return find(nums1, 0, nums2, 0, n / 2 + 1);
        }
    }


    private double find(int[] nums1, int i, int[] nums2, int j, int k) {
        System.out.println("i:" + i + " j: " + j + "k:" + k);
        //保证nums1的长度小于nums2
        if(nums1.length - i > nums2.length - j) {
            return find(nums2, j, nums1, i, k);
        }

        //结束条件, nums1已经没有可以取的元素了
        if(nums1.length == i) {
            System.out.print("nums1 length 1");
            return nums2[j + k - 1];
        }

        //结束条件, 表示还剩一个值, 所以取两个数组第一个元素最小的值即可
        if(k == 1) {
            System.out.print(" " +  nums1[i] + " " + nums2[j]);
            return Math.min(nums1[i], nums2[j]);
        }

        //进行剔除
        int idx1 = Math.min(nums1.length, i + k / 2);
        //此处无需在意是偶数还是奇数, 处理的数据量是一样的 k / 2
        int idx2 = j + k - k / 2;

        if (nums1[idx1 - 1] < nums2[idx2 - 1]) {
            return find(nums1, idx1, nums2, j, k - (idx1 - i));
        } else {
            return find(nums1, i, nums2, idx2, k - (idx2 - j));
        }
    }
}
