package com.leo.ibatis.multi;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/25
 * @description
 */
public class CasTest implements Runnable{

    private volatile int memVal;

    public synchronized int compareAndSwap(int expected,int newVal) {
        System.out.println(Thread.currentThread().getName() + "开始修改");
        int oldVal = memVal;
        if (oldVal == expected) {
            memVal = newVal;
            System.out.println(Thread.currentThread().getName() + "修改成功...");
        } else {
            System.out.println(Thread.currentThread().getName() + "修改失败" + "内存值"  + oldVal + "预期值" + expected);
        }
        return expected;
    }

    @Override
    public void run() {
        compareAndSwap(100, 500);
    }

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        CasTest casTest = new CasTest();
        casTest.memVal = 20;

        final Thread t1 = new Thread(casTest);
        final Thread t2 = new Thread(casTest);
        t1.start();
        t2.start();
    }
}
