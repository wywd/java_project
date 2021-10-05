package com.wangyu.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 标注这个类是一个springboot的应用；启动类下的所有资源被导入
// @Configuration 在里面，spring配置类
// @Component 在里面，说明这也是一个spring的组件
// @EnableAutoConfiguration 在里面，可以自动配置
// @AutoConfigurationPackage 自动配置包
@SpringBootApplication
public class HellospringbootApplication {

	public static void main(String[] args) {
		// 将springboot应用启动
		SpringApplication.run(HellospringbootApplication.class, args);
	}

}
