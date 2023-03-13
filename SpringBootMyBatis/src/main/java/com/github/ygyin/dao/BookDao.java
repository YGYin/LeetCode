package com.github.ygyin.dao;

import com.github.ygyin.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {
    @Select("select * from book_tb where id = #{id}")
    public Book getById(Integer id);
}
