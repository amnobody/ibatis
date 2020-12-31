package com.leo.ibatis.web;

import com.leo.ibatis.util.R;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/22
 * @description
 */
@RestControllerAdvice
public class GlobalExceptionResolve {

    @ModelAttribute("loginUser")
    public R exceptionHandler() {
        System.out.println("直接返回");
        return R.ok("-----------------");
    }
}
