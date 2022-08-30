package com.zean.leetcode;

import java.util.HashMap;
import java.util.Map;

/****
 * zengxiangcai
 * 2022/8/24 00:07
 *
 * 数组中找两个数只之和为给定值
 *
 * 思路一：两层循环遍历（时间O(N^2),空间O(1)）
 * 思路二：空间换时间，遍历数组，每次遍历记录对应数组期望的对应值以及下标（可以使用hash表和dict来处理）
 ***/
public class Task1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer related = target - nums[i];
            if (temp.containsKey(nums[i])) {
                result[0] = temp.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                temp.put(related, i);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new Task1().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.err.println(String.format("[%d,%d]", result[0], result[1]));
    }
}
