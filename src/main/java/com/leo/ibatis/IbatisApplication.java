package com.leo.ibatis;

import com.leo.ibatis.web.GlobalExceptionResolve;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * 排除包扫描
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.leo.ibatis.*"},excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {GlobalExceptionResolve.class}))
public class IbatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbatisApplication.class, args);
	}

}
