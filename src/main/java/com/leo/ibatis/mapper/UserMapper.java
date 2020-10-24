package com.leo.ibatis.mapper;

import com.leo.ibatis.entity.User;
import com.leo.ibatis.util.req.UserListReq;
import com.leo.ibatis.util.resp.UserListResp;
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

    List<UserListResp> selectList(UserListReq userListReq);

    void insert(List<User> list);

}
