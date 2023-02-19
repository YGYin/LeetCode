package com.github.ygyin.mapper;

import com.github.ygyin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    User selectById(int id);

    /**
     * 条件查询
     * 1. 散装参数：如果方法有多个参数，需要使用@Param("占位符名称")
     * 2. 对象参数：pojo 对象属性名称要和占位符名称一致
     * 3. 用 map 封装：key - 占位符名称一致 value - 传递参数
     *
     * @param username
     * @param addr
     * @return
     */
    List<User> selectByCondition(@Param("username") String username, @Param("addr") String addr);
//    List<User> selectByCondition(User user);

    // 单条件动态查询
    List<User> selectBySingleCondition(User user);
}
