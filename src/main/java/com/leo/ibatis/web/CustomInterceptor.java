package com.leo.ibatis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/01/12
 * @description 验证拦截器拦截抛出异常之后请求还会继续执行吗
 */
public class CustomInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);
    static int count = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (!(handler instanceof HandlerMethod)) {
            logger.error("错误的拦截资源");
            return true;
        }
//        final PrintWriter writer = response.getWriter();
//        Map<String, Object> map = new HashMap<>();
//        map.put("tip", "test before return");
//        writer.write(JSON.toJSONString(map));
//        writer.flush();
//        writer.close();
        count++;
        logger.info("流试验...拦截器流关闭=[{}],调用次数=[{}],请求路径={}", response.isCommitted(), count, request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
