package com.leo.ibatis.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;

import java.util.Arrays;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/01/19
 * @description 错误跳转页面配置
 */
//@Configuration
public class ErrorPageConfigure {

//    @Bean
    public ErrorPageFilter errorPageFilter() {
        return new ErrorPageFilter();
    }

//    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(errorPageFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.setName("custom1");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
