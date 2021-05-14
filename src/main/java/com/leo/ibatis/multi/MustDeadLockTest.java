package com.leo.ibatis.multi;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/26
 * @description
 */
public class MustDeadLockTest implements Runnable {

    private int flag;
    private Object lock1;
    private Object lock2;

    public MustDeadLockTest(int flag, Object lock1, Object lock2) {
        this.flag = flag;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        if (flag == 1) {
            synchronized (lock1) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {

                }
            }
        } else {
            synchronized (lock2) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {

                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Object lock1 = new Object();
        final Object lock2 = new Object();
        final MustDeadLockTest task1 = new MustDeadLockTest(1, lock1, lock2);
        final MustDeadLockTest task2 = new MustDeadLockTest(2, lock1, lock2);
        final Thread t1 = new Thread(task1, "订单1");
        final Thread t2 = new Thread(task2, "用户2");
        t1.start();
        t2.start();

        Thread.sleep(10000);

        ThreadMXBean detect = ManagementFactory.getThreadMXBean();
        final long[] deadlockedThreads = detect.findDeadlockedThreads();
        if (deadlockedThreads != null && deadlockedThreads.length != 0) {
            for (int i = 0; i < deadlockedThreads.length; i++) {
                final ThreadInfo threadInfo = detect.getThreadInfo(deadlockedThreads[i]);
                System.out.println(threadInfo.toString());
            }
        }
    }
}
