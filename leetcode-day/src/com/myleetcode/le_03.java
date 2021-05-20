package com.myleetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ClassName:    le_03
 * Package:    com.leetcode
 * Description: 最长无重复子串 - 人人二手车面试题目
 * Datetime:    2021/5/6   16:26
 * Author:   houyufei@fulong.tech
 */
public class le_03 {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }

    /**
     * 官方题解  abcabcbb
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = 0;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (k < s.length() && !set.contains(s.charAt(k))) {
                set.add(s.charAt(k));
                k++;
            }
            len = Math.max(len, k - i);
        }
        return len;
    }

    /**
     * 滑动窗口 跳着走
     */
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}

