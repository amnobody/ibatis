package com.leo.ibatis.config;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ChenJiWei
 * @version V1.0
 * @Description 异步执行线程池配置
 * @date 2020/08/13
 */
@Configuration
@EnableAsync
public class AsyncConfiguration implements AsyncConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(AsyncConfiguration.class);

    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_SECONDS = 200;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 2000;

    @Bean("threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setKeepAliveSeconds(KEEP_ALIVE_SECONDS);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadGroupName("线程组...");
        executor.setThreadNamePrefix("线程...");
        executor.initialize();
        return executor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return threadPoolTaskExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> logger.error(String.format("执行异步任务'%s'", method), ex);
    }

    @Bean("mdcThreadPool")
    public ThreadPoolExecutorMdcExecutor threadPoolExecutorMdcWrapper() {
        ThreadPoolExecutorMdcExecutor executor = new ThreadPoolExecutorMdcExecutor(
                CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_SECONDS, TimeUnit.SECONDS
                , new LinkedBlockingQueue<>(20),
                new CustomThreadFactory("订单服务")
        );
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    static class CusTask implements Runnable {

        private int order;

        public CusTask(int order) {
            this.order = order + 1;
        }

        @SneakyThrows
        @Override
        public void run() {
            logger.info("开始处理序号{}", order);
            Thread.sleep(1000);
        }
    }


    public static void main(String[] args) {
        ThreadPoolExecutorMdcExecutor executor = new ThreadPoolExecutorMdcExecutor(
                2, 10, KEEP_ALIVE_SECONDS, TimeUnit.SECONDS
                , new LinkedBlockingQueue<>(20),
                new CustomThreadFactory("订单服务")
        );
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 100; i++) {
            executor.execute(new CusTask(i));
        }
        System.out.println("主线程结束");
    }
}
