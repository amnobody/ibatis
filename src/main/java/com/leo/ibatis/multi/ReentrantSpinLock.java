package com.leo.ibatis.multi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/21
 * @description
 */
public class ReentrantSpinLock {

    private AtomicReference<Thread> atomic = new AtomicReference<>();

    private int count;

    public void lock() {
        final Thread thread = Thread.currentThread();
        if (atomic.get() == thread) {
            //重入锁
            ++count;
            return;
        }
        while (!atomic.compareAndSet(null, thread)) {
            System.out.println(thread.getName() + "开始自旋");
        }
    }

    public void unlock() {
        final Thread thread = Thread.currentThread();
        //持有锁的线程才能解锁
        if (atomic.get() == thread) {
            if (count > 0) {
                --count;
            } else {
                atomic.set(null);
            }
        }
    }

    public static void main(String[] args) {
        ReentrantSpinLock lock = new ReentrantSpinLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "开始获取锁...");
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "开始处理任务...");
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
