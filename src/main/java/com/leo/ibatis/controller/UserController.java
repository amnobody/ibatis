package com.leo.ibatis.controller;

import com.leo.ibatis.service.IUserService;
import com.leo.ibatis.util.R;
import com.leo.ibatis.util.common.RequestPage;
import com.leo.ibatis.util.req.UserListReq;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    IUserService userService;

    @RequestMapping("list")
    public R list(@RequestBody UserListReq userListReq) {
        return R.ok(userService.list(userListReq));
    }

    @RequestMapping("page")
    public R page(@RequestBody RequestPage<UserListReq> request) {
        return R.ok(userService.page(request));
    }


}
