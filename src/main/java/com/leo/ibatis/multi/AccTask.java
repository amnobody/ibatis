package com.leo.ibatis.multi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/22
 * @description
 */
public class AccTask implements Runnable{

    private LongAccumulator accumulator;
    private CountDownLatch latch;
    private int i;

    public AccTask(LongAccumulator accumulator, CountDownLatch latch, int i) {
        this.accumulator = accumulator;
        this.latch = latch;
        this.i = i;
    }

    @Override
    public void run() {
        accumulator.accumulate(i);
        latch.countDown();
    }
}
