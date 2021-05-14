package com.leo.ibatis;

import lombok.SneakyThrows;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/03/30
 * @description
 */
public class AK implements Runnable {

    private String name;

    public AK(String name) {
        this.name = name;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            TimeUnit.SECONDS.sleep(10);
            if (name.equals("java")) {
                System.out.println("任务..." + name);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String str = "意外身故    意外全残 新冠身故 新冠伤残 新冠全残 新冠确诊津贴";
        final List<String> collect = Arrays.stream(str.split(" ")).map(String::trim)
                .filter(s -> !StringUtils.isEmpty(s)).distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
