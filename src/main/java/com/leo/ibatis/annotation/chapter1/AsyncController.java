package com.leo.ibatis.annotation.chapter1;

import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/13
 */
@RestController
@RequestMapping(value = "user")
public class AsyncController {

    @Resource
    private AsyncService asyncService;

    @RequestMapping(value = "async1")
    public void async1() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("controller方法开始");
        asyncService.async();
        System.out.println("controller方法结束");
        stopWatch.stop();
        System.out.println(String.format("主线程总共耗时:%s", stopWatch.getTotalTimeSeconds()));
    }
}
