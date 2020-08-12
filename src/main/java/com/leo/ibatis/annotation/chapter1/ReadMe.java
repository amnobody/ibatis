package com.leo.ibatis.annotation.chapter1;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * DESC: @Async
 * 1.前世今生
 *  - springboot3.0版本之后出现,org.springframework.scheduling.annotation下
 *
 * 2.使用场景
 *  - 指定方法使其异步执行
 *
 * 3.使用方法
 *  - 开启异步开关  @EnableAsync
 *  - 需要异步方法上配置注解 @Async
 *
 * 4.注意事项
 *
 * 5.扩展
 *  - 可以使用自定义的ThreadPoolTaskExecutor异步线程执行器
 *
 * @author JiWei.Chen
 * @date 2020/08/13
 */
public class ReadMe {

    ThreadPoolTaskExecutor threadPoolTaskExecutor;
}
