package com.leo.ibatis.observer;

import java.util.Observable;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/09/20
 */
public class Writer extends Observable {

    public void insert() {
        System.out.println("发布新书");
        setChanged();
        notifyObservers();
    }
}
