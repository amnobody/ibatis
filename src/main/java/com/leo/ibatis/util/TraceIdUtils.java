package com.leo.ibatis.util;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/01/29
 * @description
 */
public class TraceIdUtils {

    public static String getTraceId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        final HashMap<Object, Object> map = new HashMap<>(20);
    }

    public Object lock = new Object();

    private static int count = 1;

    public void service() {
        synchronized (lock) {
            try {
                System.out.println(count++);
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test() {
        
    }
    public final void test(String s) {

    }


}
