package com.example.multidatasourcedemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author Gary
 * @className MybatisConfigOne
 * @description TODO
 * @date 2019-10-28 14:56
 **/
@Configuration
@MapperScan(basePackages = "com.example.multidatasourcedemo.mapper.mapper2", sqlSessionFactoryRef = "sqlSessionFactory2")
public class MybatisConfigTwo {

    @Bean
    public SqlSessionFactory sqlSessionFactory2(@Qualifier("dsTwo") DataSource datasource) {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(datasource);
            sqlSessionFactoryBean.setMapperLocations(
                    new PathMatchingResourcePatternResolver().getResources("classpath:mapper/mapper2/*.xml"));
            org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
            configuration.setMapUnderscoreToCamelCase(true);
            sqlSessionFactoryBean.setConfiguration(configuration);
            sqlSessionFactoryBean.setTypeAliasesPackage("com.example.multidatasourcedemo.model");
            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate2(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "transactionManager2")
    public DataSourceTransactionManager transactionManager2(@Qualifier("dsTwo") DataSource datasource){
        return new DataSourceTransactionManager(datasource);
    }

}
