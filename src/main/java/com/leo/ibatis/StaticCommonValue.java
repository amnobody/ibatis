package com.leo.ibatis;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/02
 * @description 静态常量和静态变量的区别
 */
public class StaticCommonValue {

    public final static String finalParam = "final value ";

    public static String param = "456";

    static {
        System.out.println("类装载");
    }

    public static void main(String[] args) throws InterruptedException {
//        System.out.println(StaticCommonValue.finalParam);
        System.out.println(StaticCommonValue.param);

        final Thread thread = new Thread(() -> {
            System.out.println("...线程");
        });
        thread.start();
        thread.join();
        System.out.println("main");
    }
}
