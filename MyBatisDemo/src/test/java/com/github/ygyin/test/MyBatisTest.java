package com.github.ygyin.test;

import com.github.ygyin.mapper.UserMapper;
import com.github.ygyin.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.selectAll();
        System.out.println(users);

        sqlSession.close();

    }

    @Test
    public void testSelectById() throws IOException {
        int id = 1;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectById(id);
        System.out.println(user);

        sqlSession.close();

    }

    @Test
    public void testSelectByCondition() throws IOException {

        String addr = "Guangdong";
        String username = "YG";

        addr = "%" + addr + "%";
        username = "%" + username + "%";

        // 封装对象
        User user = new User();
        user.setAddr(addr);
//        user.setUsername(username);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.selectByCondition(username, "");
//        List<User> users = userMapper.selectByCondition(user);
        System.out.println(users);

    }

    @Test
    public void testSelectBySingleCondition() throws IOException {

        String addr = "Guangdong";
        String username = "YG";

        addr = "%" + addr + "%";
        username = "%" + username + "%";

        // 封装对象
        User user = new User();
        user.setAddr(addr);
//        user.setUsername(username);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.selectBySingleCondition(user);

        System.out.println(users);

    }
}