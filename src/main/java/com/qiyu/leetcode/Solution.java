package com.qiyu.leetcode;

/**
 * Problem: 342. Power of Four
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 *
 * Follow up: Could you solve it without loops/recursion?
 *
 * Credits:
 * Special thanks to @yukuairoy for adding this problem and creating all test cases.
 */
public class Solution {
    public boolean isPowerOfFour(int num){

        //1. 如果小于等于零则认为不是4的幂次
        //2. 4的幂必须是2的幂, 2的幂二进制表示只有1个1, num - 1与num进行与操作的0
        //3. 4的幂也是2的幂, 且只能再偶数位置上, 所以去所有基数位置都是1的值0x55555555与之与操作

        //同时拥有一个%3 = 1, 观察得到
        //return num > 0 && (num & (num - 1)) == 0 && ((num % 3) == 1);

        return num > 0 && (num & (num - 1)) == 0 && ((num & 0x55555555) == num);
    }
}
