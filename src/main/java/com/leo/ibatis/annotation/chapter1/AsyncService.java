package com.leo.ibatis.annotation.chapter1;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * DESC: 模拟测试异步方法的执行情况
 *
 * @author JiWei.Chen
 * @date 2020/08/13
 */
@Service
public class AsyncService {

    @Async
    public void async() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopWatch.stop();
        System.out.println(String.format("异步方法耗时：%s", stopWatch.getTotalTimeSeconds()));
    }
}
