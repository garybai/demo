package com.example.jtademo.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author Gary
 * @className MybatisConfigOne
 * @description TODO
 * @date 2019-10-28 14:56
 **/
@Configuration
// 配置扫描的mapper包
@MapperScan(basePackages = "com.example.jtademo.mapper1", sqlSessionFactoryRef = "sqlSessionFactory1")
public class MybatisConfigOne {

    @Autowired
    private DataSource1Config dataSource1Config;

    @Primary
    @Bean(name = "oneDataSource")
    public DataSource oneDataSource() {
        // 这里datasource要使用阿里的支持XA的DruidXADataSource
        DruidXADataSource datasource = new DruidXADataSource();
        BeanUtils.copyProperties(dataSource1Config, datasource);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(datasource);
        xaDataSource.setUniqueResourceName("oneDataSource");
        return xaDataSource;

    }

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory1(@Qualifier("oneDataSource") DataSource datasource) {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            //注入相应的DataSource
            sqlSessionFactoryBean.setDataSource(datasource);
            // 配置mapper.xml文件位置
            sqlSessionFactoryBean.setMapperLocations(
                    new PathMatchingResourcePatternResolver().getResources("classpath:mapper1/*.xml"));
            // 开启驼峰下划线默认转换
            org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
            configuration.setMapUnderscoreToCamelCase(true);
            sqlSessionFactoryBean.setConfiguration(configuration);
            // 配置别名包
            sqlSessionFactoryBean.setTypeAliasesPackage("com.example.jtademo.model");
            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionTemplate1(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
