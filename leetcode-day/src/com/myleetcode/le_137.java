package com.myleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:    leetcode
 * Package:    com
 * Description: 只出现一次的数字 II
 * Datetime:    2021/4/30   12:35
 * Author:   houyufei@fulong.tech
 */
public class le_137 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 2};
        System.out.println(singleNumber(nums));
    }

    /***
     * 功能描述:   只出现一次的数字 II
     * 创建时间:  2021/4/30 13:08
     * @param nums:
     * @return int
     * author houyufei@fulong.tech
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        //ini
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 0);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = map.get(nums[i]);
            if (temp == 0) {
                map.put(nums[i], 1);
            } else {
                for (Integer key : map.keySet()) {
                    if (key == nums[i]) {
                        map.put(nums[i], map.get(key) + 1);
                    }
                }
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) != 3) {
                return key;
            }
        }
        return 0;
    }

    /**
     * 功能描述:
     * 创建时间:  2021/4/30 14:00
     *
     * @param nums:
     * @return int
     * author houyufei@fulong.tech
     */
    public static int leSingleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        //初始化
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }
}
