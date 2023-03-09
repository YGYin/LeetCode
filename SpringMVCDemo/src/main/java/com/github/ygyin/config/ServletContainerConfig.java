package com.github.ygyin.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;

// 4. 定义一个 Servlet 容器启动的配置类，在里面加载 Spring 的配置
public class ServletContainerConfig extends AbstractDispatcherServletInitializer {
    // 用于加载 SpringMVC 容器配置
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringMvcConfig.class);
        return context;
    }

    // 设置有哪些请求归属 SpringMVC 处理
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 加载 Spring 容器配置
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }

    // 乱码处理

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }

}

//public class ServletContainer extends AbstractAnnotationConfigDispatcherServletInitializer{
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[0];
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[]{SpringMvcConfig.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//}
