package com.example.dynamicdatasourcedemo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gary
 * @className MybatisConfig
 * @description TODO
 * @date 2019-10-29 14:27
 **/
@Configuration
@MapperScan("com.example.dynamicdatasourcedemo.mapper")
public class MybatisConfig {

    @Bean("dsOne")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource dsOne() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("dsTwo")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource dsTwo() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put("dsOne", dsOne());
        dataSourceMap.put("dsTwo", dsTwo());
        // 将 one 数据源作为默认指定的数据源
        dynamicDataSource.setDefaultDataSource(dsOne());
        // 将 one 和 two 数据源作为指定的数据源
        dynamicDataSource.setDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        // 配置数据源，此处配置为关键配置，如果没有将 dynamicDataSource作为数据源则不能实现切换
        sessionFactoryBean.setDataSource(dynamicDataSource());
        sessionFactoryBean.setTypeAliasesPackage("com.example.dynamicdatasourcedemo.model");    // 扫描Model
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));    // 扫描映射文件
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true); // 开启驼峰下划线默认转换
        sessionFactoryBean.setConfiguration(configuration);
        return sessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        // 配置事务管理, 使用事务时在方法头部添加@Transactional注解即可
        return new DataSourceTransactionManager(dynamicDataSource());
    }

}
