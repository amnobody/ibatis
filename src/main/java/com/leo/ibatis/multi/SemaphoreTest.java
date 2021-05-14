package com.leo.ibatis.multi;

import java.util.concurrent.Semaphore;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/23
 * @description
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);

        try {
            semaphore.acquire(4);
            Thread.sleep(4000);
            System.out.println("业务处理完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release(6);
            System.out.println("释放成功 ");
        }

    }
}
