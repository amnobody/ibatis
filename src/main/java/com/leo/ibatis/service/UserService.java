package com.leo.ibatis.service;

import com.leo.ibatis.mapper.UserMapper;
import com.leo.ibatis.util.req.UserListReq;
import com.leo.ibatis.util.resp.UserListResp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/10/24
 * @description
 */
@Service
public class UserService implements IUserService{

    @Resource
    UserMapper userMapper;

    @Override
    public List<UserListResp> list(UserListReq baseRequest) {
        return userMapper.selectList(baseRequest);
    }

}
