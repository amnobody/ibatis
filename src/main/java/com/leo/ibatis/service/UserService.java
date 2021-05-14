package com.leo.ibatis.service;

import com.leo.ibatis.mapper.UserMapper;
import com.leo.ibatis.util.req.UserListReq;
import com.leo.ibatis.util.resp.UserListResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/10/24
 * @description
 */
@CacheConfig(cacheNames = "c-users")
@Service
public class UserService implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    UserMapper userMapper;


    @Override
    public void print() {
        logger.info("service中当前执行业务线程===" + Thread.currentThread().toString());
        System.out.println("user");
    }

    @Override
    @Retryable(maxAttempts = 10,backoff = @Backoff(delay = 10))
    public void retry() {
        System.out.println("业务方法开始");
        int i = 1 / 0;
    }

    @Override
    public List<UserListResp> list(UserListReq baseRequest) {
        return null;
    }
}
