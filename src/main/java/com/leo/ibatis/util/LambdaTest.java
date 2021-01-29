package com.leo.ibatis.util;

import java.util.Arrays;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/01/26
 * @description
 */
public class LambdaTest {

    public static void main(String[] args) {
        final StringBuilder collect = Arrays.asList("jwc", "chenjiwei", "chenjw", "chen").stream().filter(s -> s.contains("jw"))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(collect);
    }
}
