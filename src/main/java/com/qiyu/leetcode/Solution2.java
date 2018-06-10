package com.qiyu.leetcode;

public class Solution2 {

    public int countPrimes(int n) {
        boolean[] mark = new boolean[n];

        if (n < 3) return 0;
        if (n == 3) return 1;
        if (n == 4) return 2;

        int count = 0;
        for (int i = 3; i < n; i += 2){
            if (!mark[i]){
                count ++;
                if(i * i > n)  continue;
                for (int j = 2; i * j < n; j++){
                    mark[i * j] = true;
                }
            }
        }

        return count + 1;
    }
}
