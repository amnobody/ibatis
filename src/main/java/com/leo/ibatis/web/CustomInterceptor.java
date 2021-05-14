package com.leo.ibatis.web;

import com.leo.ibatis.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/01/12
 * @description 拦截器中设置请求id
 */
public class CustomInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //第三方http调用
//        final String traceId = Objects.isNull(request.getHeader(Constants.TRACE_ID)) ?
//                UUID.randomUUID().toString().replaceAll("-", "") : request.getHeader(Constants.TRACE_ID);
//        logger.info("生成日志追踪id={}", traceId);
//        MDC.put(Constants.TRACE_ID, traceId);
//        logger.info("请求traceId:{}", traceId);
//        if (!(handler instanceof HandlerMethod)) {
//            logger.error("非静态拦截资源");
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        final String trace = MDC.get(Constants.TRACE_ID);
        logger.info("请求结束，traceId={}", trace);
        MDC.remove(Constants.TRACE_ID);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
