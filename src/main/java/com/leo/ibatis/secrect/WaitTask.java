package com.leo.ibatis.secrect;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/13
 * @description
 */
public class WaitTask implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {

        }
        System.out.println("执行结束");
    }

    public static void main(String[] args) {
        final Thread thread = new Thread(new WaitTask());
        thread.start();

        synchronized (WaitTask.class) {
            try {
                System.out.println("...");
                thread.wait(20000);
                System.out.println("恢复执行");
            } catch (InterruptedException e) {
                System.out.println("异常");
                e.printStackTrace();
            }
        }

        new Thread(() -> {
            thread.interrupt();
        }).start();

    }
}
