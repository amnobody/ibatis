package com.leo.ibatis.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/05/11
 * @description
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cha = target - nums[i];
            if (map.get(nums[i]) != null) {
                return new int[]{i, map.get(nums[i])};
            } else {
                map.put(cha, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            int[] nums = new int[]{2,7,11,15};int target = 9;
            Solution solution = new Solution();
            print(solution.twoSum(nums, target));
        }).start();

    }

    public static void print(int[] array) {
        if (array == null) {
            System.out.println("kong shu zu");
        } else {
            for (int i : array) {
                System.out.println(i);
            }
        }
    }
}
