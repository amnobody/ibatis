package com.leo.ibatis.core;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/07
 */
public class MongoController {

    public static void main(String[] args) {
        MongoService mongoService = new MongoService();
        Thread thread1 = new Thread(new MongoThread(mongoService));
        thread1.setName("..........线程1");
        Thread thread2 = new Thread(new MongoThread(mongoService));
        thread2.setName(">>>>>>>>>>线程2");
        thread1.start();
        thread2.start();
    }
}
