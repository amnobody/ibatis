package com.leo.ibatis.core;

import java.util.concurrent.locks.ReentrantLock;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/07
 */
public class MongoService {

    public static ReentrantLock reentrantLock = new ReentrantLock();

    public void save() {
        System.out.println(Thread.currentThread().getName() + "线程进入方法");
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "线程拿到锁");
            Thread.sleep(10000L);
            System.out.println(Thread.currentThread().getName() + "线程释放锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
