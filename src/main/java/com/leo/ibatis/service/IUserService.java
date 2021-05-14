package com.leo.ibatis.service;

import com.leo.ibatis.util.req.UserListReq;
import com.leo.ibatis.util.resp.UserListResp;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
public interface IUserService extends BaseService<UserListReq, UserListResp> {

    void print();

    void retry();
}
