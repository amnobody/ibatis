package com.leo.ibatis.entity;
import java.util.ArrayList;
import java.util.List;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
public class User {
    private int id;
    private int pid;
    private String username;

    private int age;

    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        final User user = new User();
        user.setList(new ArrayList<String>());
        user.setId(0);
        user.setPid(0);
        user.setUsername("123");
        user.setAge(0);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", pid=" + pid +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
