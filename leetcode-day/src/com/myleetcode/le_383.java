package com.myleetcode;

/**
 * ClassName:    le_383
 * Package:    com.leetcode
 * Description: 赎金信
 * Datetime:    2021/4/30   15:04
 * Author:   houyufei@fulong.tech
 */
public class le_383 {

    public static void main(String[] args) {
        System.out.println(canConstruct("ab", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char ransomNoteList[] = ransomNote.toCharArray();
        char magazineList[] = magazine.toCharArray();
        int sum = 0;
        for (int i = 0; i < ransomNoteList.length;) {
            for (int j = 0; j < magazineList.length; j++) {
                if (ransomNoteList[i] == magazineList[j]) {
                    i++;
                    sum++;
                    break;
                }
            }
        }
        if(sum == ransomNoteList.length){
            return true;
        }
        return false;
    }
}
