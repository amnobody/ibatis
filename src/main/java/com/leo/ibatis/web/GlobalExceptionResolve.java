package com.leo.ibatis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/22
 * @description
 */
@RestControllerAdvice
public class GlobalExceptionResolve {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolve.class);

//    @ExceptionHandler({Exception.class})
//    @ResponseBody
//    public R exceptionHandler(Exception e) {
//        logger.info("全局异常处理器");
//        return R.error("GlobalExceptionResolve...");
//    }
}
