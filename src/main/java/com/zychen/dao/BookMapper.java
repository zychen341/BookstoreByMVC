package com.zychen.dao;

import com.zychen.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加
    int addBook(Book book);

    //删除
    int deleteBookById(@Param("id") int id);

    //修改
    int updateBook(Book book);

    //查询
    Book queryBookById(@Param("id") int id);

    //查询
    List<Book> queryAllBook();

    //查询
    List<Book> queryBook(@Param("bookName")String bookName);
}
