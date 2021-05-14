package com.leo.ibatis.web;

import com.leo.ibatis.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/22
 * @description
 */
@RestControllerAdvice
public class GlobalExceptionResolve {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolve.class);

    /**
     * 404异常处理
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public R errorHandler() {
        logger.info("404");
        return R.error("404GlobalExceptionResolve...");
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public R exceptionHandler(Exception e) {
        logger.info("全局异常处理器");
        return R.error("GlobalExceptionResolve...");
    }

    public static void main(String[] args) {
    }
}
