package com.leo.ibatis.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leo.ibatis.entity.Role;
import com.leo.ibatis.entity.User;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/28
 * @description
 */
public class Test {

    public static Role mock() {
        Role role = new Role();
        role.setLevel(0);
        role.setDisplay(false);
        role.setId("10010");
        role.setRoleName("administrator");
        role.setOrderBy("name desc;");

        User user = new User();
        user.setId(0);
        user.setPid(0);
        user.setUsername("nicksong");
        user.setAge(0);

        role.setUserList(Arrays.asList(user));
        return role;
    }


    public static void test() {
        ObjectMapper objectMapper = new ObjectMapper();
        final Role role = mock();
        try {
            final String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(role);
            System.out.println(s);

            final Role role1 = objectMapper.readValue(s, Role.class);
            System.out.println(role1);

            final JsonNode jsonNode = objectMapper.readValue(s, JsonNode.class);
            System.out.println(jsonNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void yaml() {

    }

    public static void staticFunc(String s) {
        System.out.println("静态函数：" + s);
    }

    public static void sout() {
        PrintStream ps = new PrintStream(System.out);
        ps.println("hello world");

        Consumer<String> function = System.out::println;
        function.accept("hello world lambda");

        final Consumer consumer = x -> System.out.println(x);
        consumer.accept("hello");
    }

    public static void foreach(List<String> list, Consumer<String> consumer) {
        for (String s : list) {
            consumer.accept(s);
        }
    }

    public static void main(String[] args) {
//        test();
//        sout();
        final List<String> list = new ArrayList<>(Arrays.asList("123", "3123"));
        final String s = ExportUtils.doExport(list, new CsvExporter());
        System.out.println(s);
    }
}
