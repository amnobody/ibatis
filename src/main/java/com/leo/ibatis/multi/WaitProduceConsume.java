package com.leo.ibatis.multi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/14
 * @description
 */
public class WaitProduceConsume {

    private Queue queue;
    private int maxSize = 16;

    public WaitProduceConsume(int size) {
        this.maxSize = size;
        queue = new LinkedList();
    }

    public synchronized void put(Object obj) throws InterruptedException {
        if (queue.size() == maxSize) {
            wait();
        }
        queue.add(obj);
        notifyAll();
    }

    public synchronized Object take() throws InterruptedException {
        if (queue.size() == 0) {
            wait();
        }
        final Object remove = queue.remove();
        notifyAll();
        return remove;
    }

    public static void main(String[] args) {
        WaitProduceConsume queue = new WaitProduceConsume(30);
        Runnable produce = () -> {
            try {
                while (true) {
                    queue.put(new Object());
                    System.out.println(Thread.currentThread().getName() + "生产");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable consume = () -> {
            try {
                while (true) {
                    queue.take();
                    System.out.println(Thread.currentThread().getName() + "消费");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(produce).start();
        new Thread(produce).start();
        new Thread(produce).start();
        new Thread(consume).start();
        new Thread(consume).start();
        new Thread(consume).start();
        new Thread(consume).start();
    }
}
