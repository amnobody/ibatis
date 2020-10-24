package com.leo.ibatis.observer;

import org.springframework.context.ApplicationEvent;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/09/20
 * @description
 */
public class ProductSaveEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public ProductSaveEvent(Object source) {
        super(source);
    }
}
