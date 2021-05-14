package com.leo.ibatis.entity;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leo.ibatis.util.req.BaseRequest;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.Serializable;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/19
 */
public class Role extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 7089699938704876104L;

    private String id;

    @NotEmpty(message = "角色名称不能为空")
    private transient String roleName;

    private Integer sort;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public static int loop() {
        int res = 0;
        boolean stop = false;
        for (; ; ) {
            if (stop) {
                return res;
            } else {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                    if (i == 98){
                        res = i;
                        stop = true;
                    }

                }
            }
        }
    }

    public static void json() {
        Role role = new Role();
        role.setId("123");
        role.setRoleName("admin");
        System.out.println(JSON.toJSONString(role));

        final ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
        try {
            System.out.println("以下是jackson——mapper");
            System.out.println(mapper.writeValueAsString(role));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static float calcG(float kb) {
        return kb * 20_0000 * 365 * 2 / 1024 / 1024;
    }

    public static void testThread() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程开始计算");
            int i = 1 / 0;
            System.out.println("线程执行结束");
        }).start();
    }

    public static void main(String[] args) {
//        json();
//        System.out.println("最后返回"+loop());
//        System.out.println(calcG(0.9f));
        testThread();
    }
}
