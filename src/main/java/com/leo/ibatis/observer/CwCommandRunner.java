package com.leo.ibatis.observer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/30
 * @description
 */
@Component
@Order(value = 1)
public class CwCommandRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner启动" + args);
    }
}
