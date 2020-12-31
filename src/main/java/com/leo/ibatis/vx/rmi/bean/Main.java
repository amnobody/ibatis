package com.leo.ibatis.vx.rmi.bean;

import java.lang.reflect.Proxy;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/31
 * @description
 */
public class Main {
    public static void main(String[] args) {
        UserRemote user = new UserRemote();
        UserRemoteHandler handler = new UserRemoteHandler(user);
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //动态代理生成被代理对象
        final Object o = Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{UserInterface.class}, handler);
        ((UserInterface) o).sayHello();
    }
}
