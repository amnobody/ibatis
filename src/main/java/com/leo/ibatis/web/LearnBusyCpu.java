package com.leo.ibatis.web;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/01/19
 * @description
 */
public class LearnBusyCpu {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        final Thread thread = new Thread(() -> {
            int i = 0;
            while (true) {
                i = (i++) / 100;
            }
        });
        thread.setName("模拟密集型任务线程");
        thread.start();
    }


}
