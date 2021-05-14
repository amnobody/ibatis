package com.leo.ibatis.config;

import com.leo.ibatis.util.ThreadMdcUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.concurrent.*;
import java.util.regex.Pattern;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/01/29
 * @description 自定义线程池
 */
public class ThreadPoolExecutorMdcExecutor extends ThreadPoolExecutor {
    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolExecutorMdcExecutor.class);

    public ThreadPoolExecutorMdcExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public ThreadPoolExecutorMdcExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public ThreadPoolExecutorMdcExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public ThreadPoolExecutorMdcExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }


    @Override
    public void execute(Runnable command) {
        super.execute(ThreadMdcUtil.wrap(command, MDC
                .getCopyOfContextMap()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(ThreadMdcUtil.wrap(task, MDC
                .getCopyOfContextMap()));
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return super.submit(ThreadMdcUtil.wrap(task, MDC
                .getCopyOfContextMap()), result);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return super.submit(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        logger.info("线程池信息={},异常信息{}................", r.getClass(), t.toString());
    }

    static Pattern pattern = Pattern.compile("com.kbao.kbcsearch.*.bean");

    public static void main(String[] args) {
        final boolean matches = pattern.matcher("com.kbao.kbcsearch.entityrecognition11.bean").matches();
        System.out.println(-12 >> 2);

    }
}
