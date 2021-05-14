package com.leo.ibatis.controller;

import com.leo.ibatis.config.ThreadPoolExecutorMdcExecutor;
import com.leo.ibatis.entity.Role;
import com.leo.ibatis.entity.User;
import com.leo.ibatis.mapper.UserMapper;
import com.leo.ibatis.service.IUserService;
import com.leo.ibatis.service.RoleService;
import com.leo.ibatis.util.R;
import com.leo.ibatis.util.common.RequestPage;
import com.leo.ibatis.util.req.UserListReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
@RestController
@RequestMapping("user")
public class UserController extends User {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    IUserService userService;
    @Resource
    UserMapper userMapper;
    @Resource
    Map<String, IUserService> userServiceMap;
    @Resource
    ThreadPoolExecutorMdcExecutor mdcThreadPool;
    @RequestMapping("list")
    public R list() {
        return R.ok(userService.list(null));
    }

    @RequestMapping("build")
    public R build(@RequestBody List<String> list) {
        System.out.println(list);
        return R.ok(list);
    }

    @RequestMapping("save")
    public R save(@RequestBody User user) {
        userMapper.insertCondition(user);
        return R.ok(user);
    }

    @RequestMapping("update")
    public R update(@RequestBody User user) {
        userMapper.updateCondition(user);
        return R.ok(user);
    }

    /**
     * web请求路径
     * 请求字段空字符串替换为null
     *
     * @return
     */
    @RequestMapping("testGet")
    public R testGet(User user) {
        userService.retry();
        return R.ok(user);
    }


    @Resource
    RoleService roleService;
    @RequestMapping("testThread")
    public R testThread() {
        logger.info("请求进入controller");
        for (int i = 0; i < 2; i++) {
            mdcThreadPool.execute(() -> {
                roleService.delete();
            });
        }
        return R.ok();
    }

    @RequestMapping("testmap")
    public R testmpa() {
        userServiceMap.forEach((k, v) -> {
            v.print();
        });
        return R.ok();
    }

    @ExceptionHandler
    public R exception(Exception e) {
        logger.error("controller 内部ExceptionHandler", e);
        return R.error();
    }

    @RequestMapping("page")
    public R page(@RequestBody RequestPage<UserListReq> request) {
        return R.ok(userService.page(request));
    }


    @RequestMapping("test")
    public R test() {
        Role.testThread();
        return R.ok(userMapper.select());
    }

    public static void main(String[] args) {

        final Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream();
        stream.parallel().forEach(System.out::println);
    }
}
