package com.leo.ibatis.controller;

import com.leo.ibatis.config.SpringContextUtil;
import com.leo.ibatis.config.ThreadPoolExecutorMdcWrapper;
import com.leo.ibatis.entity.User;
import com.leo.ibatis.mapper.UserMapper;
import com.leo.ibatis.service.IUserService;
import com.leo.ibatis.util.R;
import com.leo.ibatis.util.common.RequestPage;
import com.leo.ibatis.util.req.UserListReq;
import com.leo.ibatis.web.GlobalExceptionResolve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
@RestController
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    IUserService userService;
    @Resource
    UserMapper userMapper;
    @Resource
    Map<String, IUserService> userServiceMap;
    @Resource
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Resource
    ThreadPoolExecutorMdcWrapper mdcThreadPool;


    @RequestMapping("testThread")
    public R testThread() {
        logger.info("请求进入controller");
        System.out.println(MDC.get("traceId"));
        mdcThreadPool.execute(() -> {
            logger.info("请求进入controller 异步线程 开始");
            userMapper.selectList(new UserListReq());
            logger.info("请求进入controller 异步线程 结束");
        });
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
        logger.error("controller 内部ExceptionHandler");
        return R.error();
    }

    @RequestMapping("list")
    public R list() {
        logger.info("流试验...开始调用list方法");
        final GlobalExceptionResolve bean = SpringContextUtil.getApplicationContext().getBean(GlobalExceptionResolve.class);
//        try {
//            final PrintWriter writer = response.getWriter();
//            writer.write("hhh");
//            writer.flush();
//            logger.info("流试验...flush之后流是否关闭={}", response.isCommitted());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if (1 == 1) {
            throw new RuntimeException("controller 异常");
        }
        return R.ok(userService.list(null));
    }

    @RequestMapping("page")
    public R page(@RequestBody RequestPage<UserListReq> request) {
        return R.ok(userService.page(request));
    }


    @RequestMapping("test")
    public R test() {
        return R.ok(userMapper.select());
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        User user = new User();
        final String name = user.getClass().getName();
        System.out.println(name);
        final Class<?> clazz = Class.forName(name);
        final Object o = clazz.newInstance();

        final Object object = new User();
    }
}
