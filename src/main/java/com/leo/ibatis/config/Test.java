package com.leo.ibatis.config;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/03/17
 * @description
 */
public class Test {

    public static final int count = 1;

    public static void main(String[] args) {
        AsyncConfiguration config = new AsyncConfiguration();
        final ThreadPoolExecutorMdcExecutor executor = config.threadPoolExecutorMdcWrapper();
        executor.execute(() -> {
            handle(9);
        });
    }

    public static int handle(int i) {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        i = 1 / 0;
        return i;
    }
}
