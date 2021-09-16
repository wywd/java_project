package com.wangyu.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * class SpringConfiguration
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/11 10:09
 **/
// 标志该类是Spring的核心配置文件
@Configuration
@ComponentScan("com.wangyu")  // 配置组件扫描
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {

}
