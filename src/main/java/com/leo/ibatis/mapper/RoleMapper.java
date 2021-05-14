package com.leo.ibatis.mapper;

import com.leo.ibatis.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
@Mapper
public interface RoleMapper {

    List<Role> selectList(Role role);

    Integer deleteByParams(Map<String, Object> map);
}
