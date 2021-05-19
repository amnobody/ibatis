package com.leo.ibatis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/05/17
 * @description
 */
@ConfigurationProperties(prefix = "spring.thread.pool")
@Configuration
@Data
public class PoolConfig {

    private int coreSize;

    private int maxSize;

    private int queueCapacity;

    private int keepAliveSeconds;
}
