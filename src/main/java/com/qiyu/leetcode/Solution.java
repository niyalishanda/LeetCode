package com.qiyu.leetcode;

class Solution {
    public void exec() {
        this.minDistance("word1", "word2");
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        //空字符串的判断
        if(m == 0 || n == 0) {
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for(int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                char char1 = word1.charAt(i-1);
                char char2 = word2.charAt(j-1);
                if(char1 == char2) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //三种情况
                    //1. insert
                    // 当前word1比word2少一个字符串, 也就是说word1和word2的(除了最后一个字符的其他字符是相等的)
                    int insert = dp[i][j-1] + 1;
                    //2. delete
                    int delete = dp[i-1][j] + 1;
                    //3. replace
                    int replace = dp[i-1][j-1] +1;
                    dp[i][j] = Math.min(Math.min(insert, delete), replace);
                }

            }
        }

        return dp[m][n];
    }
}
