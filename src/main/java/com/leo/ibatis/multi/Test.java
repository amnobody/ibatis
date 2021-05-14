package com.leo.ibatis.multi;

import java.util.concurrent.TimeUnit;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/21
 * @description
 */
public class Test {

    public synchronized void read() {
        System.out.println("模拟读开始");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("模拟读结束");
    }

    public synchronized void write(){
        System.out.println("模拟写开始...");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("模拟写结束...");
    }

    public static void main(String[] args) throws InterruptedException {
//        Hashtable<Integer, Integer> tab = new Hashtable<>(65535);
//        final Thread thread = new Thread(() -> {
//            tab.put(1, 1000);
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        thread.start();
//
//        Thread.sleep(1000);
//        final Thread thread1 = new Thread(() -> {
//            System.out.println("......."+tab.get(7000));
//        });
//        thread1.start();

        Test test = new Test();
        final Thread thread2 = new Thread(() -> test.read());
        thread2.start();
//        TimeUnit.SECONDS.sleep(1);
        final Thread thread3 = new Thread(() -> test.write());
        thread3.start();
    }
}
