package com.leo.ibatis.vx.rmi.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/31
 * @description
 */
public class SimpleInvocationHandler implements InvocationHandler {

    private Object target;

    public SimpleInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 被代理类执行方法后 实际上该方法在invoke内部执行，在执行前后可以添加处理，达到增强作用
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理开始" + method.getName());
        method.invoke(target);
        System.out.println("代理结束");
        return target;
    }
}
