package com.leo.ibatis.multi;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/27
 * @description
 */
public class CustomerTest implements Runnable {

    private Object leftLock;
    private Object rightLock;
    private CyclicBarrier cyclicBarrier;

    @Override
    public void run() {
        try {
            printAction("就绪等待");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        while (true) {
            printAction("就坐");
            synchronized (leftLock) {
                printAction("拿到左筷子");
                synchronized (rightLock) {
                    printAction("拿到右侧筷子");
                }
            }
        }
    }

    private void printAction(String action) {
        System.out.println(Thread.currentThread().getName() + "" + action);
    }

    public CustomerTest(Object leftLock, Object rightLock, CyclicBarrier cyclicBarrier) {
        this.leftLock = leftLock;
        this.rightLock = rightLock;
        this.cyclicBarrier = cyclicBarrier;
    }

    public static void main(String[] args) {
        int count = 5;
        CustomerTest[] customerTests = new CustomerTest[count];
        Object[] locks = new Object[5];
        for (int i = 0; i < locks.length; i++) {
            locks[i] = new Object();
        }
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        for (int i = 0; i < customerTests.length; i++) {
            if (i == (count - 1)) {
                customerTests[i] = new CustomerTest(locks[(i + 1) % count], locks[i], cyclicBarrier);
            } else {
                customerTests[i] = new CustomerTest(locks[i], locks[(i + 1) % count], cyclicBarrier);
            }
            new Thread(customerTests[i], "线程" + i).start();
        }


    }

    public final int countAll = 0;

}
