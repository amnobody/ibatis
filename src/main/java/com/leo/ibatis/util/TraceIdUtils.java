package com.leo.ibatis.util;

import java.util.UUID;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/01/29
 * @description
 */
public class TraceIdUtils {
    
    public static String getTraceId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
