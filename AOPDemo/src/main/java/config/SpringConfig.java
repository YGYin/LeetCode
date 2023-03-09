package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"config", "dao", "aop"})
@EnableAspectJAutoProxy // 告诉 Spring 是用注解开发的 aop，对应启动 MyAdvice 的 @Aspect
public class SpringConfig {
}
