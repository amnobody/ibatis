package com.leo.ibatis.entity;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
public class User implements Serializable {

    private static final long serialVersionUID = 8728914498434140904L;
    private int id;
    private int pid;
    private String username;
    private int age;

    private List<String> roleNames;

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
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

    public static void main(String[] args) throws IOException {
        final User user = new User();
        user.setRoleNames(new ArrayList<String>());
        user.setId(0);
        user.setPid(0);
        user.setUsername("你好");
        user.setAge(0);
        File file1 = new File("/Users/chenjiwei/hello1.txt");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(user);
        } catch (IOException e) {
            throw new RuntimeException("序列化对象异常", e);
        }
        final byte[] bytes = baos.toByteArray();
        final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file1));
        oos.writeObject(bytes);
        oos.flush();
        oos.close();

        File file2 = new File("/Users/chenjiwei/hello2.txt");
        final ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(file2));
        final String json = JSON.toJSONString(user);
        oos2.writeObject(json);
        oos2.flush();
        oos2.close();

        System.out.println("...............");
        System.out.println("字节存储文件大小" + file1.length());
        System.out.println("字符存储文件大小"+ file2.length());
    }
}
