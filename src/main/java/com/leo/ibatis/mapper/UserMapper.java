package com.leo.ibatis.mapper;

import com.leo.ibatis.entity.User;
import com.leo.ibatis.util.req.UserListReq;
import com.leo.ibatis.util.resp.UserListResp;
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

    List<UserListResp> selectList(UserListReq userListReq);

    void insert(List<User> list);

    Cursor<User> selectAll(Map<String,Object> map);
}
