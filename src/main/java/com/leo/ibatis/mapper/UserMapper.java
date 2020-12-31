package com.leo.ibatis.mapper;

import com.leo.ibatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;
import java.util.Map;

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

    Cursor<User> selectAll(Map<String,Object> map);
}
