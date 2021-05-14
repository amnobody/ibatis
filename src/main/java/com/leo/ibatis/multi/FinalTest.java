package com.leo.ibatis.multi;

import com.leo.ibatis.entity.User;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/27
 * @description
 */
public class FinalTest {

    public void test(User user) {
        System.out.printf("方法中"+ user);
        user = new User();
        System.out.println("方法中"+user);
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        FinalTest finalTest = new FinalTest();
        finalTest.test(user);
        System.out.println(user.toString());
    }
}
