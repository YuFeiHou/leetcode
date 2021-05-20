package com.myleetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ClassName:    le_239
 * Package:    com.myleetcode
 * Description:  滑动窗口最大值
 * Datetime:    2021/5/14   10:54
 * Author:   houyufei@fulong.tech
 */
public class le_239 {

    public static void main(String[] args) {
        int nums[] = new int[]{1, 3, -1};
        int numds[] = maxSlidingWindow2(nums, 2);
        for (int i = 0; i < numds.length; i++) {
            System.out.print(numds[i]);
        }
    }

    /**
     * 教程解法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int right = 0;
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        // 开始构造窗口
        while (right < nums.length) {
            //这里的list的首位必须是窗口中最大的那位
            while (!list.isEmpty() && nums[right] > list.peekLast()) {
                list.removeLast();
            }
            // 不断添加
            list.addLast(nums[right]);
            right++;
            //构造窗口完成，这时候需要根据条件做一些操作
            if (right >= k) {
                res[index++] = list.peekFirst();
                // 如果发现第一个已经在窗口外面了，就移除
                if (list.peekFirst() == nums[right - k]) {
                    list.removeFirst();
                }
            }
        }
        return res;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        //移动右边指针
        for (int right = 0; right < nums.length; right++) {
            //删除list中最前面的
            list.remove(k);

            //如何从list中找出一个最大的值？ 正序排序 + 取出最后面一位放进数组中。

            //移动左边指针的同时要考虑窗口的大小不能变，因此右边的指针也得向前走
            while (list.size() > k) {
                left++;
            }
        }
        return null;
    }

    /**
     * 思路： 遍历数组 L R 为滑窗左右边界 只增不减
     * 双向队列保存当前窗口中 最大的值 的数组下标 双向队列中的数从大到小排序，
     * 新进来的数如果大于等于队列中的数 则将这些数弹出 再添加
     * 当R-L+1=k 时 滑窗大小确定 每次R前进一步L也前进一步 保证此时滑窗中最大值的
     * 数组下标在[L，R]中，并将当前最大值记录
     * 举例： nums[1，3，-1，-3，5，3，6，7] k=3
     * 1：L=0，R=0，队列【0】 R-L+1 < k
     * 队列代表值【1】
     * 2: L=0,R=1, 队列【1】 R-L+1 < k
     * 队列代表值【3】
     * 解释：当前数为3 队列中的数为【1】 要保证队列中的数从大到小 弹出1 加入3
     * 但队列中保存的是值对应的数组下标 所以队列为【1】 窗口长度为2 不添加记录
     * 3: L=0,R=2, 队列【1，2】 R-L+1 = k ,result={3}
     * 队列代表值【3，-1】
     * 解释：当前数为-1 队列中的数为【3】 比队列尾值小 直接加入 队列为【3，-1】
     * 窗口长度为3 添加记录记录为队首元素对应的值 result[0]=3
     * 4: L=1,R=3, 队列【1，2，3】 R-L+1 = k ,result={3，3}
     * 队列代表值【3，-1,-3】
     * 解释：当前数为-3 队列中的数为【3，-1】 比队列尾值小 直接加入 队列为【3，-1，-3】
     * 窗口长度为4 要保证窗口大小为3 L+1=1 此时队首元素下标为1 没有失效
     * 添加记录记录为队首元素对应的值 result[1]=3
     * 5: L=2,R=4, 队列【4】 R-L+1 = k ,result={3，3，5}
     * 队列代表值【5】
     * 解释：当前数为5 队列中的数为【3，-1，-3】 保证从大到小 依次弹出添加 队列为【5】
     * 窗口长度为4 要保证窗口大小为3 L+1=2 此时队首元素下标为4 没有失效
     * 添加记录记录为队首元素对应的值 result[2]=5
     * 依次类推 如果队首元素小于L说明此时值失效 需要弹出
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> list = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小 弹出
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            // 添加当前值对应的数组下标
            list.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
            if (list.peek() <= i - k) {
                list.poll();
            }
            // 窗口长度为k时 再保存当前窗口中最大值
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[list.peek()];
            }
        }
        return result;
    }

    /**
     * 暴力破解法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return nums;
        }
        //这个地方一定要注意，结果集的长度为
        int[] res = new int[length - k + 1];
        for (int i = 0; i < length && i + k <= length; i++) {
            res[i] = getMax(nums, i, i + k);
        }
        return res;
    }

    private static int getMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

}
