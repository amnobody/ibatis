package com.leo.ibatis.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/24
 * @description redis缓存
 */
@Component
@Aspect
public class UserGroupRedisAop {

    @Pointcut("execution(public * com.leo.ibatis.service.UserService.*(..)))")
    public void point() {

    }

    @Before(value = "point()")
    public void before(JoinPoint joinPoint) {
        final Object[] args = joinPoint.getArgs();
        System.out.println("...aop before" + Thread.currentThread().getId());
    }

    @AfterReturning(value = "point()")
    public void after(JoinPoint joinPoint) {
        final Object[] args = joinPoint.getArgs();
        System.out.println("...aop after" + Thread.currentThread().getId());
    }


}
