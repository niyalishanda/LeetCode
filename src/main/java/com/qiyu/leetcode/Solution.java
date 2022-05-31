package com.qiyu.leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public void exec() {
        System.out.println(minWindow2("ADOBECODEBANC", "ABC"));
    }

    public String minWindow2(String s, String t) {
        Map<Character, Integer> runingMap = new HashMap<>();
        Map<Character, Integer> templateMap = new HashMap<>();

        //初始化模板
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            templateMap.put(ch, templateMap.getOrDefault(ch, 0) + 1);
        }

        //进行指针移动
        int left = 0;
        int right = 0;

        //结束条件, 右边完成移动
        String ans = "";
        //记录有效字符的次数
        int count = 0;

        for (; right < s.length(); right++) {
            //指针向右走
            char ch = s.charAt(right);
            if (!templateMap.containsKey(ch)) {
                continue;
            }

            //添加字符出现次数
            runingMap.put(ch, runingMap.getOrDefault(ch, 0) + 1);
            //有效字符
            if (runingMap.get(ch) <= templateMap.get(ch)) {
                count++;
            }

            //左指针移动
            while (true) {
                //左边的字符
                char lch = s.charAt(left);
                //非包含的字符, 直接舍弃
                if (!templateMap.containsKey(lch)) {
                    left++;
                    if (left > right) {
                        right++;
                    }
                    continue;
                }

                //包含的字符, 且有用的大于需要的, 进行移动, 减去1
                if (runingMap.get(lch) > templateMap.get(lch)) {
                    runingMap.put(lch, runingMap.get(lch) - 1);
                    left++;
                    continue;
                }
                break;
            }

            //可以获取答案了
            if (count >= t.length()) {
                ans = ans.length() == 0 || ans.length() >= right - left + 1 ? s.substring(left, right + 1) : ans;
            }
        }
        return ans;
    }


    public String minWindow(String s, String t) {
        Map<Character, Integer> sm = new HashMap<>();
        Map<Character, Integer> tm = new HashMap<>();
        int count = 0;

        //初始化s的HashMap
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int value = 1;
            if (tm.containsKey(c)) {
                value = tm.get(c) + 1;
            }
            tm.put(c, value);
        }

        //进行s的滑动窗口
        int left = 0;
        int right = 0;

        String ans = "";
        while (right < s.length()) {
            char c = s.charAt(right);
            sm.put(c, sm.getOrDefault(c, 0) + 1);
            if (tm.get(c) != null && sm.get(c) <= tm.get(c)) {
                count++;
            }

            while (right >= left && (tm.get(s.charAt(left)) == null || sm.get(s.charAt(left)) > tm.get(s.charAt(left)))) {
                if (sm.containsKey(s.charAt(left))) {
                    sm.put(s.charAt(left), sm.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }

            if (count >= t.length()) {
                if (ans.isEmpty()) {
                    ans = s.substring(left, right + 1);
                } else {
                    ans = (ans.length() >= right - left + 1) ? s.substring(left, right + 1) : ans;
                }

            }
            right++;
        }

        return ans;
    }
}
