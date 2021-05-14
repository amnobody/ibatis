package com.leo.ibatis.vx.rmi.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/03/12
 * @description
 */
public class NoImplementInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //连接jdbc
        System.out.println("数据库连接执行前置操作");
        //execute sql
        return "success result";
    }

    public static void main(String[] args) {
        final PayService proxy = (PayService)Proxy.newProxyInstance(PayService.class.getClassLoader(),
                new Class[]{PayService.class},
                new NoImplementInvocationHandler());
        String result = proxy.pay();
        System.out.println(result);
    }
}
