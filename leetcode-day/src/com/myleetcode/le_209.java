package com.myleetcode;

/**
 * ClassName:    le_209
 * Package:    com.myleetcode
 * Description: 最长连续子数组
 * Datetime:    2021/5/13   14:12
 * Author:   houyufei@fulong.tech
 */
public class le_209 {

    /**
     * 正确版本
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen_L(int target, int[] nums) {
        int left = 0;
        int lenght = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                lenght = Math.min(lenght, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        if (lenght == Integer.MAX_VALUE) {
            return 0;
        }
        return lenght;
    }

    /**
     * 第一次思路的理解是错误的
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int   [] nums) {
        int right = 0;
        int lenght = Integer.MAX_VALUE;
        for (int left = 0; left < nums.length; left++) {
            int sum = 0;
            while (sum < target) {
                sum += nums[right];
                right++;
            }
            if (sum == target) {
                lenght = Math.min(lenght, right - left + 1);
            }
        }
        return lenght;
    }
}
