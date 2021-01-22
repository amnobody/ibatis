package com.leo.ibatis.vx.rmi.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/31
 * @description
 */
public class UserRemoteHandler implements InvocationHandler {

    private UserRemote userRemote;

    public UserRemoteHandler(UserRemote userRemote) {
        this.userRemote = userRemote;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行代理invoke方法");
        method.invoke(userRemote);
        System.out.println("结束执行代理invoke方法");
        return userRemote;
    }
}
