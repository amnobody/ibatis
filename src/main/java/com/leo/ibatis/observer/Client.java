package com.leo.ibatis.observer;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/09/20
 */
public class Client {

    public static void main(String[] args) {
        Reader reader = new Reader();
        Writer writer = new Writer();
        writer.addObserver(reader);
        writer.insert();
    }
}
