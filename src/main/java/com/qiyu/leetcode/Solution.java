package com.qiyu.leetcode;

import java.util.HashMap;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class Solution {

    public int countPrimes(int n) {

        if (n < 3) return 0;

        boolean[] records = new boolean[n];

        int res = 0;

        for (int i = 3; i < n; i += 2){

            if (records[i]){
                res = records[i] ? res + 1 : res;
                continue;
            }

            boolean is = isPrime2(i);
            if (is) {
                records[i] = is;
                res += 1;
            }
        }

        return res + 1;
    }

    private static boolean isPrime2(int n){
        if (n < 2) return false;
        if(n == 2|| n == 3) return true;

        //不在6的倍数两侧的一定不是质数
        if(n % 6!= 1 && n %6 != 5) {
            return false;
        }

        //在6的倍数两侧的也可能不是质数
        int temp = (int) Math.sqrt(n);
        for(int i = 5; i <= temp; i += 6)
            if(n % i == 0 || n % (i + 2) == 0 )
                return false ;
        //排除所有，剩余的是质数
        return true;
    }

    /**
     * 是否是素数
     * @param n
     * @return
     */
    private static boolean isPrime(int n){
        if (n < 2) return false;
        if (n % 2 == 0) return false;
        int temp = (int) Math.sqrt(n);
        for (int i = 3; i <= temp; i += 2){
            if (n % i == 0) return false;
        }
        return true;
    }
}
