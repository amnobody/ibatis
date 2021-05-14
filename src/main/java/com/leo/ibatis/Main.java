package com.leo.ibatis;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/03/30
 * @description
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> list = (Arrays.asList(1,2,3,4,5,6).stream().collect(Collectors.toList()));
        for (int i = 0; i < list.size(); i++) {
            System.out.println("..." + list.get(i));
            if (list.get(i) == 4) {
                list.remove(i);
            }
            System.out.println(">>>" + list.get(i));
        }
    }
}
