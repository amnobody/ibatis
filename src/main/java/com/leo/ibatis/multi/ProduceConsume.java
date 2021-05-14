package com.leo.ibatis.multi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/14
 * @description
 */
public class ProduceConsume {

    public static void main(String[] args) {
//        BlockingQueue queue = new ArrayBlockingQueue(10);
        ProduceConsume queue = new ProduceConsume(20);

        Runnable producer = () -> {
            while (true) {
                try {
                    queue.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }


    ReentrantLock lock = new ReentrantLock();
    final Condition notEmpty = lock.newCondition();
    final Condition notFull = lock.newCondition();
    Queue queue;
    int size = 16;

    public Queue getQueue() {
        return queue;
    }

    public ProduceConsume(int size) {
        queue = new LinkedList();
        this.size = size;
    }

    public void put(Object object) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == size) {
                notFull.await();
            }
            queue.add(object);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            final Object remove = queue.remove();
            System.out.println("取出" + remove.toString());
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
