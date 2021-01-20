package com.leo.ibatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.leo.ibatis.*"},excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {GlobalExceptionResolve.class}))
public class IbatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbatisApplication.class, args);
	}

}
