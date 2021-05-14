package com.leo.ibatis.observer;

import com.alibaba.fastjson.JSON;
import com.leo.ibatis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/09/20
 * @description
 */
@Component
@Slf4j
public class ProductLabelListener implements ApplicationListener<ProductSaveEvent> {
    @Override
    public void onApplicationEvent(ProductSaveEvent event) {
        Object source = event.getSource();
        User user = (User)source;
        System.out.println("事件source" + JSON.toJSONString(user));
        System.out.println("ProductLabelListener 开始监听事件");
    }

    @EventListener
    public void customSaveEvent(ProductSaveEvent event) {
        log.info("注解实现监听事件..." + event.getSource());
    }
}
