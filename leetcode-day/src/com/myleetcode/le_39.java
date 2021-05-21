package com.myleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:    le_39
 * Package:    com.myleetcode
 * Description: 组合总和 TODO 怎么确认重复的集合呢？ 例如： 235 tar=8   [2,2,2,2],[2,3,3], [3,5] 为什么没 53 323这些呢？
 *
 *
 * Datetime:    2021/5/21   14:23
 * Author:   houyufei@fulong.tech
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class le_39 {
    List<List<Integer>> res = new ArrayList<>();
    /**
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int sum = 0;
        back(candidates, target, res, path, 0, sum);
        return res;
    }

    public static void back(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int stat, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = stat; i < candidates.length; i++) {
            int temp = sum + candidates[i];
            if (temp <= target) {
                path.add(candidates[i]);
                back(candidates, target, res, path, i, temp);
                //回溯撤回值
                path.remove(path.size() - 1);
            } else {
                break;
            }
        }
    }

    /**
     * 公众号解法 组合总和  如何做到去重的？？？ 24  42的问题
     * @param candidates  234 6
     * @param target
     * @param path
     * @param stat
     * @param sum
     */
    public void back2(int[] candidates, int target, List<Integer> path, int stat, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = stat; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            back2(candidates, target, path, i, sum);
            //回溯撤回值
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}
