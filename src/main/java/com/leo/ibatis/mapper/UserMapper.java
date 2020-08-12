package com.leo.ibatis.mapper;

import com.leo.ibatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
@Mapper
public interface UserMapper {

    List<User> selectList();

    void insert(List<User> list);

}
