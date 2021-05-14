package com.leo.ibatis.multi;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/14
 * @description
 */
public class ThreadFileTest {

    public static void main(String[] args) {
        Runnable read = () -> {
            try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("/Users/chenjiwei/logs/ons.log"))) {
                int tempts;
                while ((tempts = inputStreamReader.read()) != -1) {
                    System.out.println(Thread.currentThread().getName() + "......." + tempts);
                }
            } catch (Exception e) {
                System.out.println("异常");
            }
        };

        new Thread(read).start();
        new Thread(read).start();
    }
}
