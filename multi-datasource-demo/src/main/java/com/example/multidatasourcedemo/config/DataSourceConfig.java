package com.example.multidatasourcedemo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @ClassName DatasourceConfig
 * @Description TODO
 * @Author Gary
 * @Date 2019-04-05 22:45
 **/
@Configuration
public class DataSourceConfig {

    @Bean // 将这个bean交给spring容器管理
    @Primary // 默认数据库
    // 读取application.yml文件中前缀为spring.datasource.one的参数映射为一个对象
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource dsOne() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource dsTwo() {
        return DruidDataSourceBuilder.create().build();
    }

}
