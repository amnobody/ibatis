package com.leo.ibatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
@Configuration
//@MapperScan(basePackages = {"com.leo"},sqlSessionTemplateRef = "sqlSessionTemplate",annotationClass = Mapper.class)
public class MybatisConfigure {


    /**
     * 数据源配置
     */
    private static final String PREFIX = "spring.datasource.druid";

    /**
     * mapper.xml路径配置
     */
    private static final List<String> MAPPER_XML = Arrays.asList("classpath*:mapper/*.xml");


    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = PREFIX)
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        List<Resource> resources = new ArrayList<>();
        for (String mapperXml : MAPPER_XML) {
            resources.addAll(Arrays.asList(resolver.getResources(mapperXml)));
        }

        try {
            bean.setMapperLocations(resources.toArray(new Resource[0]));
            bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("sqlSessionTemplate");
        mapperScannerConfigurer.setAnnotationClass(org.apache.ibatis.annotations.Mapper.class);
        mapperScannerConfigurer.setBasePackage("com.leo");
        return mapperScannerConfigurer;
    }
}
