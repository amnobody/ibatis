package com.leo.ibatis.controller;

import com.leo.ibatis.CusTask;
import com.leo.ibatis.entity.Role;
import com.leo.ibatis.entity.User;
import com.leo.ibatis.service.RoleService;
import com.leo.ibatis.util.R;
import com.leo.ibatis.util.common.RequestPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
@RestController
@RequestMapping("role")
public class RoleController {

    Map<Integer, String> map = new HashMap<>();
    AtomicInteger atomicInteger = new AtomicInteger();

    @Resource
    RoleService roleService;

    @RequestMapping("build")
    public R build(@RequestBody List<String> list, HttpServletRequest request) {

        //c2
        //c3
        map.put(atomicInteger.incrementAndGet(), request.getSession().getId());
        System.out.println(list);
        return R.ok(list);
    }

    @RequestMapping("start")
    public R start(HttpServletRequest request, HttpServletResponse response) {
        roleService.a();
        roleService.c();
        return R.ok();
    }

    @RequestMapping("add")
    public R test(@RequestBody User user) {
        System.out.println("...");
        return R.ok(CusTask.remove(user.getUsername()));
    }

    @RequestMapping("list")
    public R list(@RequestBody Role userListReq) {
        return R.ok(roleService.list(userListReq));
    }

    @RequestMapping("page")
    public R page(@RequestBody @Valid RequestPage<Role> request) {
        return R.ok(roleService.page(request));
    }

    /**
     * 数组
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 3, 3, 4, 8, 4};
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res ^= arr[i];
        }
        System.out.println(res);
        int winb = 0;
        for (int i = 0; i < 1000; i++) {


            int a = 0;
            int b = 0;


            for (int j = 0; j < 50; j++) {
                Random random = new Random();
                if (random.nextBoolean() == true) {
                    a += 1;
                }
            }

            for (int j = 0; j < 60; j++) {
                Random random = new Random();
                if (random.nextBoolean() == true) {
                    b += 1;
                }
            }
            if (b > a) {
                winb += 1;
            }
        }
        System.out.println(winb);
    }
}
