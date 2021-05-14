package com.leo.ibatis;

import com.leo.ibatis.web.GlobalExceptionResolve;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.retry.annotation.EnableRetry;

/**
 * 排除包扫描
 */
@EnableCaching
@EnableRetry
@SpringBootApplication
@ComponentScan(basePackages = {"com.leo.ibatis.*"},excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {GlobalExceptionResolve.class}))
public class IbatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbatisApplication.class, args);
	}

}
