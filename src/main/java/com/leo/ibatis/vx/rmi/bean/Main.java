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
        //1.创建被代理对象
        UserRemote user = new UserRemote();
        //2.创建被代理方法执行器(依赖被代理对象)
        SimpleInvocationHandler handler = new SimpleInvocationHandler(user);
        //动态生成代理类的class文件保存在文件系统中
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //3.动态代理生成被代理对象 (通过断点或打印 proxy为$Proxy-数字 证明该对象是JVM动态在内存中创建)
        final UserInterface proxy = (UserInterface)Proxy.newProxyInstance(Main.class.getClassLoader(), user.getClass().getInterfaces(), handler);
        proxy.sayHello();
    }
}
