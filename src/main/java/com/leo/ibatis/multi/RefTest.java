package com.leo.ibatis.multi;

import com.leo.ibatis.entity.User;

import java.lang.ref.WeakReference;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/23
 * @description
 */
public class RefTest {

    public static void main(String[] args) {
        User user = new User();
        WeakReference<User> reference = new WeakReference<User>(user);

        while (true) {
            System.out.println("强引用" + user.toString());
            if (reference.get() != null) {
                System.out.println("依然没有被回收");
            } else {
                System.out.println("被回收了");
                break;
            }
        }
    }
}
