package com.leo.ibatis.mapper;

import com.leo.ibatis.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
@Mapper
public interface RoleMapper {

    List<Role> selectList(Role role);
}
