package com.wangyu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * class SwaggerConfig
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/10/5 15:47
 **/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 配置Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");

        //  获取项目的环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)  // 配置是否启用Swagger，如果是false，在浏览器将无法访问
                .select()  // 通过.select()方法，去配置扫描接口,RequestHandlerSelectors 配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.wangyu.controller"))
                .build();
    }

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group1");
    }
    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
    }
    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
    }

    // 配置Swagger信息api-info
    private ApiInfo apiInfo() {
        // 作者信息
        Contact DEFAULT_CONTACT = new Contact("王瑜", "http://wangyu.com", "future_yu@foxmail.com");
        return new ApiInfo("王瑜的Swagger", "Swagger API 文档", "1.0", "http://localhost.com",
                DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
    }

}
