package com.example.jtademo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName DatasourceConfig
 * @Description TODO
 * @Author Gary
 * @Date 2019-04-05 22:45
 **/
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.one")
public class DataSource1Config {

    private String type;

    private String url;

    private String username;

    private String password;

}
