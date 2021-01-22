package com.leo.ibatis.config;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Properties;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/01/11
 * @description
 */
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class,
                Object.class})})
@Component
public class CustomMybatisInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(CustomMybatisInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("intercept方法开始");
        //获取方法的第0个参数，也就是MappedStatement。@Signature注解中的args中的顺序
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        //获取sql命令操作类型
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        final Object[] queryArgs = invocation.getArgs();
        final Object parameter = queryArgs[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        String sql = boundSql.getSql();
        logger.info("SQL=[{}]", sql);
        if (Objects.equals(SqlCommandType.DELETE, sqlCommandType)
                || Objects.equals(SqlCommandType.UPDATE, sqlCommandType)
                || Objects.equals(SqlCommandType.SELECT, sqlCommandType)) {
            //格式化sql
            sql = sql.replace("\n", "");
//            if (!StringUtils.containsIgnoreCase(sql, WHERE)) {
//                sql = sql.replace(" ", "");
//                log.warn("SQL 语句没有where条件，禁止执行,sql为:{}", sql);
//            }
//            throw new Exception("SQL语句中没有where条件");
        }
        Object result = invocation.proceed();
        return result;
    }

    @Override
    public Object plugin(Object target) {
        logger.info("plugin方法开始 target对象=[{}]", target.toString());
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        logger.info("setProperties方法开始");
    }
}
