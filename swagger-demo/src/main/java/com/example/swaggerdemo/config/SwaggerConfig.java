package com.example.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Gary
 * @className SwaggerConfig
 * @description TODO
 * @date 2019-11-13 14:24
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swaggerdemo"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "Spring Boot项目集成Swagger实例文档",
//                "我的博客网站：https://www.bgyly.com，欢迎大家访问。",
//                "API V1.0",
//                "Terms of service",
//                new Contact("GaryBai", "https://www.bgyly.com", "490000133@qq.com"),
//                "Apache", "http://www.apache.org/", Collections.emptyList());
        return new ApiInfoBuilder().title("Spring Boot项目集成Swagger实例文档")
                .description("我的博客网站：https://www.bgyly.com，欢迎大家访问。")
                .version("API V1.0")
                .termsOfServiceUrl("Terms of service")
                .license("Apache")
                .licenseUrl("http://www.apache.org/")
                .contact(new Contact("GaryBai", "https://www.bgyly.com", "490000133@qq.com"))
                .build();
    }
}
