package com.leo.ibatis.service;

import com.leo.ibatis.config.SpringContextUtil;
import com.leo.ibatis.entity.User;
import com.leo.ibatis.mapper.UserMapper;
import com.leo.ibatis.util.req.UserListReq;
import com.leo.ibatis.util.resp.UserListResp;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/10/24
 * @description
 */
@Service
public class UserService implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    UserMapper userMapper;

    @Override
    public List<UserListResp> list(UserListReq baseRequest) {
        System.out.println("...service list方法" + Thread.currentThread().getId());
        return userMapper.selectList(baseRequest);
    }

    public void batchInsert() {
        int size = 10000;
        for (int i = 0; i < 100; i++) {
            List<User> list = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                User user = new User();
                user.setPid(j + 1);
                user.setUsername(UUID.randomUUID().toString());
                user.setAge(20);
                User user1 = new User();
                list.add(user);
            }
            userMapper.insert(list);
        }
    }

    AtomicInteger count = new AtomicInteger();

    public void resolveStream() {
        final SqlSessionFactory factory = SpringContextUtil.getApplicationContext().getBean(SqlSessionFactory.class);

        final SqlSession sqlSession = factory.openSession();
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        StopWatch watch = new StopWatch("统计耗时");
        watch.start("游标取数据");
        try (
                final Cursor<User> cursor = mapper.selectAll(new HashMap<>());) {
            cursor.forEach(user -> {
                while (cursor.isOpen()) {

                    count.incrementAndGet();
                    System.out.println(user.toString());
                    if (cursor.getCurrentIndex() % 4000 == 0) {
                        System.out.println(cursor.getCurrentIndex() + "..." + user.toString());
                        try {
                            cursor.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e) {
            logger.info("异常", e);
        } finally {
            sqlSession.close();
        }
        watch.stop();
        logger.info("查询{}条数据，耗时={}", count.get(), watch.getTotalTimeSeconds());
    }

}
