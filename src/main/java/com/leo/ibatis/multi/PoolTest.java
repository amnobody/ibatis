package com.leo.ibatis.multi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/15
 * @description
 */
public class PoolTest {

    public long jian(long x, long y) {
        return x - y;
    }

    public static void main(String[] args) throws InterruptedException {

        int task = 10000000;



        long star1 = System.currentTimeMillis();
        long c = 0;
        for (int i = 0; i < task; i++) {
            c += i;
        }
        System.out.println(c);
        System.out.println(System.currentTimeMillis() - star1);


        final long start2 = System.currentTimeMillis();
        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0);
        CountDownLatch latch = new CountDownLatch(task);
        final ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < task; i++) {
            int finalI = i;
            service.submit(() -> {accumulator.accumulate(finalI);latch.countDown();});
        }
        latch.await();
        final long thenReset = accumulator.getThenReset();
        System.out.println(thenReset);
        System.out.println(System.currentTimeMillis() - start2);
        service.shutdown();
    }

}
