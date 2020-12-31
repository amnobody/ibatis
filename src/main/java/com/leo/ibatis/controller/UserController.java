package com.leo.ibatis.controller;

import com.leo.ibatis.entity.IService;
import com.leo.ibatis.service.UserService;
import com.leo.ibatis.util.R;
import com.leo.ibatis.util.common.RequestPage;
import com.leo.ibatis.util.req.UserListReq;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    UserService userService;
    @Resource
    List<IService> list;


    @RequestMapping("list")
    public R list(@RequestBody UserListReq userListReq) {
        return R.ok(userService.list(userListReq));
    }

    @RequestMapping("test")
    public R test(@ModelAttribute("loginUser") R param) {
        UserListReq resultReq = new UserListReq();
        resultReq.setAge(10);
        userService.list(resultReq);
        System.out.println(list.toString());
        System.out.println("进入test");
        return R.ok();
    }

    @RequestMapping("page")
    public R page(@RequestBody RequestPage<UserListReq> request) {
        return R.ok(userService.page(request));
    }

    @RequestMapping("save")
    public R save() {
        userService.batchInsert();
        return R.ok();
    }

    @RequestMapping("stream")
    public R stream() {
        userService.resolveStream();
        return R.ok();
    }
}
