package com.leo.ibatis.secrect;

import java.util.concurrent.TimeUnit;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/12
 * @description
 */
public class LockSusThread extends Thread{

    private volatile Object lock;

    public Object getLock() {
        return lock;
    }

    public void setLock(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + "获取到锁");
            try {
                TimeUnit.SECONDS.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "执行完毕");
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        final LockSusThread lockSusThread = new LockSusThread();
        lockSusThread.setLock(lock);
        lockSusThread.setName("mock dead lock thread");
        lockSusThread.start();
        Thread.sleep(44);
        lockSusThread.suspend();
        final Thread thread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("...");
            }
        });
        thread.setName("mock another thread");
        thread.start();
    }
}
