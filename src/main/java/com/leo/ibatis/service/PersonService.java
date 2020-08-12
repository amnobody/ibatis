package com.leo.ibatis.service;

import com.leo.ibatis.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/06
 */
@Service
public class PersonService implements BaseService{
    @Override
    public List<User> queryList() {
        System.out.println("person - service");
        return null;
    }
}
