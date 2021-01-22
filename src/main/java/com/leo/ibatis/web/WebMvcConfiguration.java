package com.leo.ibatis.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenJiWei
 * @version V1.0
 * @Description mvc配置
 * @date 2020/08/07
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport implements EnvironmentAware {

    /**
     * 需要拦截的请求,Ant表达式
     */
    private static String[] LOGIN_INCLUDE = {"/**"};

    /**
     * 需要排除的请求,Ant表达式
     */
    private static String[] LOGIN_EXCLUDE = {
            "/doc.html",
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/webjars/**",
            "/v2/**",
            "/swagger-ui.html/**",
            "/healthcheck",
            "/api/noauth/**",
            "/api/nonuser/**",
            "/error"

    };

    private static String[] WHITELIST_INCLUDE = {
            "/doc.html",
            "/swagger-ui.html"
    };


    @Bean
    public CustomInterceptor customInterceptor(){
        return new CustomInterceptor();
    }

    /**
     * 拦截器 集成 快保云服基础框架拦截器：要求header中有
     * tenantId 租户id
     * funcId 菜单id
     * access_token 用户token
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor()).addPathPatterns(LOGIN_INCLUDE).order(1);
    }

    /**
     * 静态资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");

    }


    @Override
    public void setEnvironment(Environment environment) {
    }

    /**
     * ResponseBody 消息转换方式
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        // 支持字符串格式转换
        converters.add(new StringHttpMessageConverter(Charset.forName("utf-8")));
        // 支持json格式转换
        converters.add(getMappingJackson2HttpMessageConverter());
    }

    @Autowired
    private ObjectMapper objectMapper;


    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        //设置中文编码格式
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.APPLICATION_JSON_UTF8);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
        return mappingJackson2HttpMessageConverter;
    }

}
