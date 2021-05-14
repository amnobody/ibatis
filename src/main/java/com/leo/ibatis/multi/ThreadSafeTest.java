package com.leo.ibatis.multi;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/14
 * @description
 */
public class ThreadSafeTest {

    private volatile static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int j = 0; j < 1000; j++) {
                i++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        final Thread thread = new Thread(runnable);
        thread.start();
        final Thread thread1 = new Thread(runnable);
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(i);
    }
}
