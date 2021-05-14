package com.leo.ibatis.web;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/03/11
 * @description
 */
@Service
@EnableScheduling
public class PeopleService {

//    @Scheduled(fixedRate = 4000)
    public void loop() {
        System.out.println("当前线程" + Thread.currentThread());
    }

    public static void main(String[] args) {
        int[] arr = {55, 2, 3, 2, 3, 4, 5, 5, 8, 4, 55};
        int res = arr[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.remove(arr[i]);
            } else {
                map.put(arr[i], i);
            }
            System.out.println("中间结果" + res);
        }
        System.out.println(map);

    }
}
