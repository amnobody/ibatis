package com.leo.ibatis.controller;

import com.leo.ibatis.entity.Role;
import com.leo.ibatis.service.IRoleService;
import com.leo.ibatis.util.R;
import com.leo.ibatis.util.common.RequestPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Resource
    IRoleService roleService;

    @RequestMapping("list")
    public R list(@RequestBody Role userListReq) {
        return R.ok(roleService.list(userListReq));
    }

    @RequestMapping("page")
    public R page(@RequestBody @Valid RequestPage<Role> request) {
        return R.ok(roleService.page(request));
    }


}
