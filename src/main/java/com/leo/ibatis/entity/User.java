package com.leo.ibatis.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
@Data
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 8728914498434140904L;
    private int id;
    private int pid;
    private String username;
    private int age;
    private List<String> roleNames;
    private List<String> list;
    private Map<String, String> map;
}
