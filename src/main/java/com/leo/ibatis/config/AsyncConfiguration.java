package com.leo.ibatis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

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
    private static final int QUEUE_CAPACITY = 20;

    @Bean("threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setKeepAliveSeconds(KEEP_ALIVE_SECONDS);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
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
    public ThreadPoolExecutorMdcWrapper threadPoolExecutorMdcWrapper() {
        ThreadPoolExecutorMdcWrapper executor = new ThreadPoolExecutorMdcWrapper(
                CORE_POOL_SIZE, MAX_POOL_SIZE,KEEP_ALIVE_SECONDS, TimeUnit.SECONDS
                ,new LinkedBlockingQueue<>(20),
                new CustomThreadFactory("订单服务")
        );
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    public static void main(String[] args) {
        final ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };
    }
}
