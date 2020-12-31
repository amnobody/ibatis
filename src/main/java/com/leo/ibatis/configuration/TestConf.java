package com.leo.ibatis.configuration;
import com.leo.ibatis.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/23
 * @description
 */
@Configuration
public class TestConf {

    @Bean
    public User user1(){
        final User user = new User();
        user.setList(new ArrayList<String>());
        user.setId(0232);
        user.setPid(021);
        user.setUsername("klkl");
        user.setAge(0123);

        return user;
    }

    @Bean
    public User user2(){
        final User user = new User();
        user.setList(new ArrayList<String>());
        user.setId(0232);
        user.setPid(021);
        user.setUsername("klkl");
        user.setAge(0123);

        return user;
    }
}
