package com.leo.ibatis.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/09/20
 */
public class Reader implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("订阅成功");
    }
}
