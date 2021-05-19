package com.leo.ibatis.service;

import com.leo.ibatis.config.AsyncConfiguration;
import com.leo.ibatis.entity.Role;
import com.leo.ibatis.mapper.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/10/24
 * @description
 */
@Service
@Slf4j
public class RoleService implements IRoleService {

    @Resource
    AsyncConfiguration asyncConfiguration;
    @Resource
    RoleMapper roleMapper;

    @Override
    public List<Role> list(Role baseRequest) {
        return roleMapper.selectList(baseRequest);
    }

    @Transactional()
    public void a() {
        log.info("a方式 事务传播级别never");
        b();
        log.info("a方法结束");
    }

    @Async(value = "threadPoolTaskExecutor")
    @Transactional(propagation = Propagation.NEVER)
    public void b() {
        log.info("b方法默认传播级别");
    }

    @Async(value = "threadPoolTaskExecutor")
    public void c() {
        final ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor)asyncConfiguration.getAsyncExecutor();
        log.info("c方法开始结束");
        log.info("线程池活跃线程数量={},总任务数量={},已完成数量={}，现存任务队列大小={}",
                executor.getActiveCount(),executor.getPoolSize(),executor.getThreadPoolExecutor().getCompletedTaskCount(),executor.getThreadPoolExecutor().getQueue().size());
    }

    @Transactional
    public void delete() {
        System.out.println("开始处理" + Thread.currentThread().getId());
        Map<String, Object> map = new HashMap<>();
        map.put("level", 20);
        map.put("userId", 1);
        roleMapper.deleteByParams(map);
        try {
            System.out.println("开始模拟长时间处理任务" + Thread.currentThread().getId());
            TimeUnit.SECONDS.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
