package com.leo.ibatis.service;

import com.leo.ibatis.entity.Role;
import com.leo.ibatis.mapper.RoleMapper;
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
public class RoleService implements IRoleService {

    @Resource
    RoleMapper roleMapper;

    @Override
    public List<Role> list(Role baseRequest) {
        return roleMapper.selectList(baseRequest);
    }

    @Resource
    RoleService roleService;

    @Transactional()
    public void a() {
        System.out.println("a方式 事务传播级别never");
        b();
        System.out.println("a方法结束");
    }

    @Transactional(propagation = Propagation.NEVER)
    public void b() {
        System.out.println("b方法默认传播级别");
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
