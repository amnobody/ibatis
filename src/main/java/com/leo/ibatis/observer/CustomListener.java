package com.leo.ibatis.observer;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/30
 * @description
 */
@Component
public class CustomListener implements ApplicationListener<AvailabilityChangeEvent> {


    @Override
    public void onApplicationEvent(AvailabilityChangeEvent event) {
        System.out.println("自定义时间监听器...");
        System.out.println(event.getState());
    }
}
