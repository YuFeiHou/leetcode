package com.myleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:    le_78
 * Package:    com.myleetcode
 * Description: 子集
 * Datetime:    2021/5/20   14:01
 * Author:   houyufei@fulong.tech
 */
public class le_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        back(nums, 0, res, list);
        return res;
    }

    /**
     * 错误 i + 1 ==>startIndex+1
     *
     * @param nums
     * @param startIndex
     * @param res
     * @param list
     */
    public static void back(int[] nums, int startIndex, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            back(nums, i + 1, res, list);
            //back
            list.remove(list.size() - 1);
        }
    }
}
