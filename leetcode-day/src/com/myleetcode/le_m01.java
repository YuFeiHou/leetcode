package com.myleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:    le_m01
 * Package:    com.myleetcode
 * Description: 面试题 10.01. 合并排序的数组
 * Datetime:    2021/5/18   12:49
 * Author:   houyufei@fulong.tech
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 */
public class le_m01 {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] B = new int[]{2, 5, 6};
        int n = 3;
        merge2(A, m, B, n);
    }

    /**
     * 直接将第二个数组的数据追加到第一个数组的末尾
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i != n; ++i) {
            A[m + i] = B[i];
        }
        Arrays.sort(A);
    }

    /**
     * 使用双指针的形式
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge2(int[] A, int m, int[] B, int n) {
        int top = 0;
        int but = 0;
        List<Integer> list = new ArrayList<>();
        while (top < m && but < n) {
            //如果第一个数组已经全部放到list中了，那么剩下就需要把b中剩下的全部放入list中
            if (top == m) {
                list.add(B[but++]);
            } else if (but == n) {
                list.add(A[top++]);
            } else if (A[top] < B[but]) {
                list.add(A[top++]);
            } else {
                list.add(B[but++]);
            }
        }
        int temp = 0;
        for (Integer integer : list) {
            A[temp] = integer;
            temp++;
        }
    }
}
