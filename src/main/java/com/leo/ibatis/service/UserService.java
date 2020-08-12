package com.leo.ibatis.service;

import com.leo.ibatis.entity.User;
import com.leo.ibatis.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
@Service
public class UserService implements BaseService{
    @Override
    public List<User> queryList() {
        System.out.println("user - service");
        return null;
    }
}
