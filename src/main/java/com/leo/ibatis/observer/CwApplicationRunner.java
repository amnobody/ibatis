package com.leo.ibatis.observer;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/30
 * @description
 */
@Component
@Order(value = 2)
public class CwApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("CwApplicationRunner启动" + args);
    }
}
