package com.leo.ibatis.service;

import com.leo.ibatis.util.req.UserListReq;
import com.leo.ibatis.util.resp.UserListResp;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/10/24
 * @description
 */
@Service
public class PersonService implements IUserService{

    @Override
    public List<UserListResp> list(UserListReq baseRequest) {
        System.out.println("person");
        return null;
    }

    @Override
    public void print() {
        System.out.println("person");
    }
}
