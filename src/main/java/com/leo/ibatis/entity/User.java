package com.leo.ibatis.entity;

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
