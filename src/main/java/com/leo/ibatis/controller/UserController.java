package com.leo.ibatis.controller;

import com.github.pagehelper.PageHelper;
import com.leo.ibatis.entity.User;
import com.leo.ibatis.mapper.UserMapper;
import com.leo.ibatis.service.BaseService;
import com.leo.ibatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
@RestController
public class UserController {

    @Resource
    UserService userService;
    @Resource
    UserMapper userMapper;
    @Autowired
    private List<BaseService> list;

    @RequestMapping(value = "/mapper")
    public Object mapper() {
        PageHelper.startPage(2, 4);
        List<User> users = userMapper.selectList();
        return users;
    }

    @RequestMapping(value = "/insert")
    public void insert(){
        List<User> list = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUserId("User"+i);
            list.add(user);
        }
        userMapper.insert(list);
        System.out.println("batch insert end");
    }


    @RequestMapping(value = "/service")
    public Object service() {
        System.out.println(list.size());
        for (BaseService baseService : list) {
            System.out.println(baseService.queryList());
        }
        return list;
    }


}
