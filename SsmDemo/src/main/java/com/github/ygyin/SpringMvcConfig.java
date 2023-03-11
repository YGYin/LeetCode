package com.github.ygyin;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.github.ygyin.controller")
@EnableWebMvc
public class SpringMvcConfig {
}
