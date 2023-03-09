package com.github.ygyin.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// 3. 创建 SpringMVC 的配置文件，加载 controller 对应的 bean
@Configuration
@ComponentScan("com.github.ygyin.controller")
@EnableWebMvc // json -> object
public class SpringMvcConfig {
}
