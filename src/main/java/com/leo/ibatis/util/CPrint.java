package com.leo.ibatis.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/02/03
 * @description
 */
public class CPrint implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(CPrint.class);

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        localDate.plus(1, ChronoUnit.DAYS);
        final List<String> collect = Arrays.asList("AK001", "AK001", "AK001").stream().collect(Collectors.toList());
        logger.info("列表={}", collect);
    }

    int count = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
//                this.notify();
                if (count <= 100) {
                    System.out.println(Thread.currentThread().getName() + "..." + count++);
                    final long l = System.currentTimeMillis();
                    while (System.currentTimeMillis() <= (l + 1000000)) {

                    }
                } else {
                    break;
                }
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}
