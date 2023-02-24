package com.github.ygyin;

import com.github.ygyin.mapper.UserMapper;
import com.github.ygyin.pojo.User;
import com.github.ygyin.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 1. 加载 MyBatis 的核心配置文件，获取 SqlSessionFactory
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        // 2. 获取 SqlSession 对象，用于执行 sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 执行 sql，命名空间加 sql id
        //    List<User> users = sqlSession.selectList("test.selectAll");
        // -> 获取接口代理 mapper 对象，再执行 sql 方法
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();

        System.out.println(users);

        // 4. 释放资源
        sqlSession.close();
    }
}
