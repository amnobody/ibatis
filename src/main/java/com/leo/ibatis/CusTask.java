package com.leo.ibatis;

import com.leo.ibatis.entity.User;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/03/27
 * @description
 */
public class CusTask implements Runnable {

    private static List<User> list = new ArrayList<>(3);

    public static List<String> strings = Arrays.asList("java", "c++", "python", "js").stream().collect(Collectors.toList());

    private static List<Runnable> tasks = new ArrayList<>();

    static {
        final AK ak = new AK("aaaaaaaa");
        final AK ak1 = new AK("bbbbbb");
        final AK ak2 = new AK("java");
        tasks.add(ak);
        tasks.add(ak1);
        tasks.add(ak2);
    }


    public CusTask() {
    }

    public static void addTask(User task) {
        list.add(task);
    }

    public static boolean remove(String name) {
        return strings.remove(name);
    }


    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            try {
                tasks.forEach(Runnable::run);
            } catch (Exception e) {
                System.out.println("异常..." + e);
            }
        }

//        for (Runnable task : tasks) {
//            while (true) {
//                try {
//                    task.run();
//                } catch (Exception e) {
//                    System.out.println("... exception" + task.toString());
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        for (String string : strings) {
            System.out.println("..." + string);
            if (string.equals("python")) {
                strings.remove(string);
            }
            System.out.println(">>>" + string);
        }

    }
}
