package com.leo.ibatis.multi;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/23
 * @description
 */
public class CompletableFutureTaskTest {

    public static void main(String[] args) {

        Supplier runnable = () -> {
            Random random = new Random();
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(20));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return random.nextInt(100);
        };

        final CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(runnable);
        final CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(runnable);
        final CompletableFuture<Integer> task3 = CompletableFuture.supplyAsync(runnable);

        final List<Integer> collect = Stream.of(task1, task2, task3).map(CompletableFuture::join).collect(Collectors.toList());

        System.out.println(collect);
    }

}
