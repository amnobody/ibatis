package com.leo.ibatis.multi;

import java.util.Random;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/28
 * @description
 */
public class MathTest {

    public static void main(String[] args) {
        Random random = new Random(1);
        int count = 10;
        int[] arr = new int[]{1,1,1,1,9};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("........");
        System.out.println(printSubArr(arr));
    }

    public void yi() {
        int i = 1;
        int j = 2;
        print(i, j);

        i = i ^ j;
        System.out.println(i);
        j = j ^ i;
        System.out.println(j);
        i = i ^ j;
        System.out.println(i);
        print(i, j);
    }

    public static int printSubArr(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void print(int i, int j) {
        System.out.println(String.format("i=%s,j=%s", i, j));
    }
}
