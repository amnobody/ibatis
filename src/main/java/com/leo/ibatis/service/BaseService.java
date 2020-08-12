package com.leo.ibatis.service;

import com.leo.ibatis.entity.User;
import com.leo.ibatis.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
public interface BaseService {



    List<User> queryList();
}
