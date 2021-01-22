package com.leo.ibatis.vx.rmi.bean;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/31
 * @description
 */
public class UserRemote implements UserInterface {

    @Override
    public void sayHello() {
        System.out.println("hello world...");
    }
}
