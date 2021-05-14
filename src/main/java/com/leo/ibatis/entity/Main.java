package com.leo.ibatis.entity;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/03/22
 * @description
 */
public class Main {
    public static void main(String[] args) {
        final String collect = Arrays.asList("a", "b", "c").stream().collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
