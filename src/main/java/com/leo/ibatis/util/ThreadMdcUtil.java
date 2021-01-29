package com.leo.ibatis.util;

import org.slf4j.MDC;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/01/29
 * @description 线程context set traceId
 */
public class ThreadMdcUtil {
    
    public static void setTraceIdIfAbsent() {
        if (Objects.isNull(MDC.get(Constants.TRACE_ID))) {
            MDC.put(Constants.TRACE_ID, TraceIdUtils.getTraceId());
        }
    }
    
    public static <T> Callable<T> wrap(final Callable<T> callable,
                                       final Map<String, String> context) {
        return () -> {
            if (Objects.isNull(context)) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            try {
                return callable.call();
            } finally {
                MDC.clear();
            }
        };
    }
    
    public static Runnable wrap(final Runnable runnable,
                                final Map<String, String> context ) {
        return () -> {
            if (Objects.isNull(context)) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            try {
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }
}
