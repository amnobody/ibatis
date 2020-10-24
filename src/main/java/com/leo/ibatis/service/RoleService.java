package com.leo.ibatis.service;

import com.leo.ibatis.entity.Role;
import com.leo.ibatis.mapper.RoleMapper;
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
public class RoleService implements IRoleService{

    @Resource
    RoleMapper roleMapper;

    @Override
    public List<Role> list(Role baseRequest) {
        return roleMapper.selectList(baseRequest);
    }

}
